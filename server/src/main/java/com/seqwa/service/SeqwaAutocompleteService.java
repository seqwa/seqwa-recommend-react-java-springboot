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

import com.seqwa.dao.AutocompleteResult;
import com.seqwa.dao.RequestObject;

@Service
public class SeqwaAutocompleteService {

	@Value("${seqwa.indexid}")
	private String indexId;
	@Value("${seqwa.autocomplete.url}")
	private String autocompleteURL;
	@Value("${seqwa.autocomplete.apikey}")
	private String autocompleteAPIKey;

	private final RestTemplate restTemplate;

	public SeqwaAutocompleteService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public AutocompleteResult autocomplete(RequestObject request) {
		String urlTemplate = UriComponentsBuilder.fromHttpUrl(autocompleteURL).queryParam("index", "{index}")
				.queryParam("query", "{query}").queryParam("fields", "{fields}")
				.queryParam("highlightField", "{highlightField}").queryParam("maxResults", "{maxResults}").encode()
				.toUriString();
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("index", indexId);
		uriVariables.put("query", request.getQuery() != null ? request.getQuery() : "");
		uriVariables.put("fields", request.getFields() != null ? request.getFields() : "title,price,link,image");
		uriVariables.put("highlightField", request.getHighlightField() != null ? request.getHighlightField() : "title");
		uriVariables.put("maxResults", request.getMaxResults() != null ? request.getMaxResults() : "25");

		HttpHeaders headers = new HttpHeaders();
		headers.set("seqwa-api-key", autocompleteAPIKey);
		headers.set("Content-Type", "application/json");

		HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(urlTemplate, HttpMethod.GET, httpEntity, AutocompleteResult.class, uriVariables)
				.getBody();
	}

}
