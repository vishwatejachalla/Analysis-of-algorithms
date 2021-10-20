package com.java.sortings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.java.commonutils.Utility;
import com.java.domain.ResultList;
import com.java.domain.Results;

public class MergeSort {

	private static String algorithm = "MERGE";
	private static String Random = "RANDOM";
	private static String increasing = "INCREASING";
	private static String decreasing = "DECREASING";
	static Utility util = new Utility();
	private static int count = 0;

	public void sort(int arr[], Results result, String arrayType) {
		double startTime = System.currentTimeMillis();

		mergeSort(arr, 0, arr.length - 1);
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

	public static int[] mergeSort(int arr[], int start, int end) {
		count++;
		int mid = (start + end) / 2;
		if (start < end) {
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
		return arr;
	}

	private static void merge(int arr[], int start, int mid, int end) {
		count++;
		int[] tempArray = new int[arr.length];
		int tempArrayIndex = start;
		int startIndex = start;
		int midIndex = mid + 1;
		while (startIndex <= mid && midIndex <= end) {
			if (arr[startIndex] < arr[midIndex]) {
				tempArray[tempArrayIndex++] = arr[startIndex++];
			} else {
				tempArray[tempArrayIndex++] = arr[midIndex++];
			}
		}
		while (startIndex <= mid) {
			tempArray[tempArrayIndex++] = arr[startIndex++];
		}
		while (midIndex <= end) {
			tempArray[tempArrayIndex++] = arr[midIndex++];
		}
		for (int i = start; i <= end; i++) {
			arr[i] = tempArray[i];
		}
	}

	public ResultList testMergeSort(int[] randomArr, int[] increasingArr, int decreasingArr[],
			HashMap<String, ResultList> finalResults) {

		Results testResults = new Results();
		testResults.setArraySize(randomArr.length);
		sort(randomArr, testResults, Random);
		sort(increasingArr, testResults, increasing);
		sort(decreasingArr, testResults, decreasing);

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
