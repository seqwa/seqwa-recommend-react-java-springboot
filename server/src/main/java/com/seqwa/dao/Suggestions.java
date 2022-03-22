package com.seqwa.dao;

public class Suggestions {

	public Suggestions() {

	}

	public Suggestions(String suggest, String displaySuggest) {
		this.suggest = suggest;
		this.displaySuggest = displaySuggest;
	}

	private String suggest;
	private String displaySuggest;

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getDisplaySuggest() {
		return displaySuggest;
	}

	public void setDisplaySuggest(String displaySuggest) {
		this.displaySuggest = displaySuggest;
	}

}
