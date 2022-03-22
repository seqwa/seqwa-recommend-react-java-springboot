package com.seqwa.dao;

import java.util.List;
import java.util.Map;

public class AutocompleteResult {
	private List<Suggestions> suggestions;
	private List<String> relatedItems;
	private List<Map<String, ?>> records;
	private String error;

	public List<Suggestions> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestions> suggestions) {
		this.suggestions = suggestions;
	}

	public List<String> getRelatedItems() {
		return relatedItems;
	}

	public void setRelatedItems(List<String> relatedItems) {
		this.relatedItems = relatedItems;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Map<String, ?>> getRecords() {
		return records;
	}

	public void setRecords(List<Map<String, ?>> records) {
		this.records = records;
	}

}
