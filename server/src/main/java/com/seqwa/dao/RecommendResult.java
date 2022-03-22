package com.seqwa.dao;

import java.util.List;
import java.util.Map;

public class RecommendResult {
	private List<Map<String, ?>> recommendations;
	private String error;

	public List<Map<String, ?>> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Map<String, ?>> recommendations) {
		this.recommendations = recommendations;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
