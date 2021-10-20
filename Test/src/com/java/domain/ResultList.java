package com.java.domain;

import java.util.List;

public class ResultList {

	private String algorithmName;
	private List<Results> results;

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return algorithmName + " " + results;
	}

}
