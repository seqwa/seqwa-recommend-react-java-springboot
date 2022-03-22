package com.seqwa.dao;

public class RequestObject {

	private String query;
	private String highlightField;
	private String maxResults;
	private String fields;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getHighlightField() {
		return highlightField;
	}

	public void setHighlightField(String highlightField) {
		this.highlightField = highlightField;
	}

	public String getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(String maxResults) {
		this.maxResults = maxResults;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

}
