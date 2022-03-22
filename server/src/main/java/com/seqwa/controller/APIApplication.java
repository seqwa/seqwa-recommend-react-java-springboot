package com.seqwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seqwa.dao.AutocompleteResult;
import com.seqwa.dao.RecommendRequestObject;
import com.seqwa.dao.RecommendResult;
import com.seqwa.dao.RequestObject;
import com.seqwa.service.SeqwaAutocompleteService;
import com.seqwa.service.SeqwaRecommendService;

@RestController
@RequestMapping(value = "/api")
public class APIApplication {

	@Autowired
	private SeqwaAutocompleteService autocompleteService;
	@Autowired
	private SeqwaRecommendService recommendService;

	/**
	 * 
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/autocomplete")
	public AutocompleteResult autocomplete(@ModelAttribute RequestObject request) {
		return autocompleteService.autocomplete(request);
	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/recommend")
	public RecommendResult recommend(@ModelAttribute RecommendRequestObject request) {
		return recommendService.recommend(request);
	}

}
