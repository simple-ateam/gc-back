package com.ateam.gc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SignatureException;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestClient {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final boolean DEBUG_MODE = true;

	private static boolean initialized = false;

	private final String baseUrl;
	private final String apiKey;
	private final String secretKey;

	public static synchronized RestClient of(String baseUrl, String apiKey, String secretKey) throws GeneralSecurityException {
		if (!initialized) {
			Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
				public <T> T readValue(String value, Class<T> valueType) {
					try {
						return OBJECT_MAPPER.readValue(value, valueType);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}

				public String writeValue(Object value) {
					try {
						return OBJECT_MAPPER.writeValueAsString(value);
					} catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}
				}
			});

			HttpClientBuilder httpClientBuilder = HttpClients.custom();
			if (baseUrl.startsWith("https://")) {
				SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
						new SSLContextBuilder()
								.loadTrustMaterial(null, new TrustSelfSignedStrategy())
								.build());
				httpClientBuilder.setSSLSocketFactory(sslSocketFactory);
			}
			if (DEBUG_MODE) {
				httpClientBuilder.addInterceptorFirst((org.apache.http.HttpRequest request, HttpContext context) -> {
				});

				httpClientBuilder.addInterceptorFirst((org.apache.http.HttpResponse response, HttpContext context) -> {
				});
			}
			Unirest.setHttpClient(httpClientBuilder.build());

			initialized = true;
		}
		return new RestClient(baseUrl, apiKey, secretKey);
	}

	public GetRequest get(String path, long customerId) throws SignatureException {
		return withAuthInfo(Unirest.get(baseUrl + path), path, customerId, apiKey, secretKey);
	}

	public HttpRequestWithBody post(String path, long customerId) throws SignatureException {
		HttpRequestWithBody request = Unirest.post(baseUrl + path);
		request.header("Content-Type", "application/json;charset=UTF-8");
		return withAuthInfo(request, path, customerId, apiKey, secretKey);
	}

	public HttpRequestWithBody delete(String path, long customerId) throws SignatureException {
		return withAuthInfo(Unirest.delete(baseUrl + path), path, customerId, apiKey, secretKey);
	}

	public HttpRequestWithBody put(String path, long customerId) throws SignatureException {
		HttpRequestWithBody request = Unirest.put(baseUrl + path);
		request.header("Content-Type", "application/json;charset=UTF-8");
		return withAuthInfo(request, path, customerId, apiKey, secretKey);
	}

	private <T extends HttpRequest> T withAuthInfo(T request, String path, long customerId, String apiKey, String secretKey) throws SignatureException {
		return request;
	}
}
