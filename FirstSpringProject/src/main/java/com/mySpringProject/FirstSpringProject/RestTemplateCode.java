package com.mySpringProject.FirstSpringProject;

public class RestTemplateCode {
	package com.nvssoftech.platform.connector.rest;

	import java.net.Proxy;

	import org.apache.http.HttpHost;
	import org.apache.http.client.config.RequestConfig;
	import org.apache.http.impl.client.CloseableHttpClient;
	import org.apache.http.impl.client.HttpClients;
	import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.client.ClientHttpRequestFactory;
	import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
	import org.springframework.http.client.SimpleClientHttpRequestFactory;
	import org.springframework.http.client.support.BasicAuthorizationInterceptor;
	import org.springframework.web.client.RestTemplate;

	import com.nvssoftech.platform.connector.rest.entity.AppConnector;
	import com.nvssoftech.platform.connector.rest.model.Authencation;
	import com.nvssoftech.platform.connector.rest.service.AppConnectorService;
	import java.security.SecureRandom;
	import javax.net.ssl.SSLContext;
	import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
	import java.security.KeyManagementException;
	import java.security.NoSuchAlgorithmException;

	public class RestTemplateManager {

	    private static PoolingHttpClientConnectionManager connectionManager;
	    private static RestTemplate singletonRestTemplate;
	    @Autowired
	    private AppConnectorService appConnectorService;

	    private static PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {
	        if (connectionManager == null) {
	            synchronized (RestTemplateManager.class) {
	                if (connectionManager == null) {
	                    connectionManager = new PoolingHttpClientConnectionManager();
	                    connectionManager.setMaxTotal(200);
	                    connectionManager.setDefaultMaxPerRoute(20);
	                }
	            }
	        }
	        return connectionManager;
	    }

	    public static RestTemplate getDefaultRestTemplate() {
	        if (singletonRestTemplate == null) {
	            singletonRestTemplate = new RestTemplate();
	        }
	        return singletonRestTemplate;
	    }

	    public static RestTemplate getDefaultRestTemplate(Proxy proxy) {
	        if (singletonRestTemplate == null) {
	            singletonRestTemplate = new RestTemplate(getSimpleClientHttpRequestFactory(proxy));
	        }
	        return singletonRestTemplate;
	    }

	    private static SimpleClientHttpRequestFactory getSimpleClientHttpRequestFactory(Proxy proxy) {
	        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	        requestFactory.setProxy(proxy);
	        return requestFactory;
	    }

	    public RestTemplate getRestTemplate() {
	        return new RestTemplate(getClientHttpRequestFactory(null));
	    }

	    public RestTemplate getRestTemplateForAppConnector(String connectId)  {
	        AppConnector appConnector = appConnectorService.getAppConnectorByConnectId(connectId);
	        if (appConnector == null) {
	            throw new IllegalArgumentException(String.format("Application connection details with connectId %s not found", connectId));
	        }
	        ClientHttpRequestFactory clientHttpRequestFactory = getClientHttpRequestFactory(appConnector);
	        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
	        if (appConnector.getAuthType() == Authencation.Type.BASIC) {
	            restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(appConnector.getUserName(), appConnector.getPassword()));
	        }
	        return restTemplate;
	    }

	    private ClientHttpRequestFactory getClientHttpRequestFactory(AppConnector appConnector) {
	        return getHttpComponentsClientHttpRequestFactory(appConnector);
	    }

	    //TODO Configure router planner as soon as possible
	    private HttpComponentsClientHttpRequestFactory getHttpComponentsClientHttpRequestFactory(AppConnector appConnector) {
	        int connectTimeout = -1;
	        int socketTimeout = -1;
	        if (appConnector != null) {
	            connectTimeout = (appConnector.getConnectTimeout() == 0) ? -1 : appConnector.getConnectTimeout();
	            socketTimeout = (appConnector.getReadTimeout() == 0) ? -1 : appConnector.getReadTimeout();
	        }
	        RequestConfig requestConfig = RequestConfig.custom()
	                .setConnectTimeout(connectTimeout)
	                .setSocketTimeout(socketTimeout)
	                .build();

	        CloseableHttpClient httpClient;
	        if (appConnector != null && appConnector.getProxyType() == Proxy.Type.HTTP) {
	            HttpHost proxy = new HttpHost(appConnector.getProxyHost(), appConnector.getProxyPort());
	            httpClient = HttpClients.custom()
	                    .setConnectionManager(RestTemplateManager.getPoolingHttpClientConnectionManager())
	                    .setDefaultRequestConfig(requestConfig)
	                    .setProxy(proxy)
	                    .build();
	        } else {
	            httpClient = HttpClients.custom()
	                    .setDefaultRequestConfig(requestConfig)
	                    .setConnectionManager(RestTemplateManager.getPoolingHttpClientConnectionManager())
	                    .build();
	        }
	        try {
	        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
	        sslContext.init(null, null, new SecureRandom());
	        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
	        httpClient =HttpClients.custom()
	        		.setSSLSocketFactory(socketFactory)
	        		.setDefaultRequestConfig(requestConfig)
	        		.build();
	        }
	        catch (Exception e)
	        {
	        	throw new RuntimeException("Error creating HttpClient", e);
	        }
	        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
	        return requestFactory;
	    }
	}

}
