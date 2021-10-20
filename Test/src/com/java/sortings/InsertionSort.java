package com.java.sortings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.java.commonutils.Utility;
import com.java.domain.ResultList;
import com.java.domain.Results;

public class InsertionSort {

	private static String algorithm = "INSERTION";
	private static String Random = "RANDOM";
	private static String increasing = "INCREASING";
	private static String decreasing = "DECREASING";
	static Utility util = new Utility();

	public static void insertionSort(int arr[], Results result, String arrayType) {
		double startTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			count++;
			int valueToSort = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1] > valueToSort; j--) {
				count++;
				arr[j] = arr[j - 1];
			}
			arr[j] = valueToSort;
		}
		double EndTime = ((System.currentTimeMillis() - startTime) / 1000);
		if (Random.equals(arrayType)) {
			result.setRandomOrderCount(count);
			result.setRandomOrderTime(EndTime);

		} else if (increasing.equals(arrayType)) {
			result.setIncOrderCount(count);
			result.setIncOrderTime(EndTime);
		} else {
			result.setDecOrderCount(count);
			result.setDecOrderTime(EndTime);
		}
		// util.printArryAsMatrix(arr);

	}

	public ResultList testInsertionSort(int[] randomArr, int[] increasingArr, int decreasingArr[],
			HashMap<String, ResultList> finalResults) {

		Results testResults = new Results();
		testResults.setArraySize(randomArr.length);
		insertionSort(randomArr, testResults, Random);
		insertionSort(increasingArr, testResults, increasing);
		insertionSort(decreasingArr, testResults, decreasing);

		ResultList result = null;
		if (finalResults.isEmpty()) {
			List<Results> results = new ArrayList<Results>();
			results.add(testResults);
			result = new ResultList();
			result.setAlgorithmName(algorithm);
			result.setResults(results);
		} else {

			if (finalResults.get(algorithm) != null) {
				result = finalResults.get(algorithm);
				List<Results> results = result.getResults();
				results.add(testResults);
				result.setResults(results);
			} else {
				List<Results> results = new ArrayList<Results>();
				results.add(testResults);
				result = new ResultList();
				result.setAlgorithmName(algorithm);
				result.setResults(results);
			}

		}
		return result;

	}
}
