package com.seqwa.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.seqwa.dao.RecommendRequestObject;
import com.seqwa.dao.RecommendResult;

@Service
public class SeqwaRecommendService {

	@Value("${seqwa.indexid}")
	private String indexId;
	@Value("${seqwa.recommend.url}")
	private String recommendURL;
	@Value("${seqwa.recommend.apikey}")
	private String recommendAPIKey;

	private final RestTemplate restTemplate;

	public SeqwaRecommendService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public RecommendResult recommend(RecommendRequestObject request) {
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(recommendURL).queryParam("index", "{index}")
				.queryParam("context", "{context}").queryParam("fields", "{fields}")
				.queryParam("recordId", "{recordId}").queryParam("maxResults", "{maxResults}").encode().toUriString();
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("index", indexId);
		uriVariables.put("context", request.getContext() != null ? request.getContext() : "");
		uriVariables.put("recordId", request.getRecordId() != null ? request.getRecordId() : "");
		uriVariables.put("fields", request.getFields() != null ? request.getFields() : "title,price,link,image");
		uriVariables.put("maxResults", request.getMaxResults() != null ? request.getMaxResults() : "25");

		HttpHeaders headers = new HttpHeaders();
		headers.set("seqwa-api-key", recommendAPIKey);
		headers.set("Content-Type", "application/json");

		HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(urlTemplate, HttpMethod.GET, httpEntity, RecommendResult.class, uriVariables)
				.getBody();
	}

}
