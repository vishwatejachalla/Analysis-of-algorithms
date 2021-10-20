
package com.java.sortings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.java.commonutils.Utility;
import com.java.domain.ResultList;
import com.java.domain.Results;

public class HeapSort {
	private static String algorithm = "HEAP";
	private static String Random = "RANDOM";
	private static String increasing = "INCREASING";
	private static String decreasing = "DECREASING";
	static Utility util = new Utility();
	private static int count = 0;

	public static void buildheap(int[] arr) {
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			count++;
			heapify(arr, i, arr.length - 1);
		}
	}

	public static void heapify(int[] arr, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max;
		if (left <= size && arr[left] > arr[i]) {
			max = left;
		} else {
			max = i;
		}

		if (right <= size && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			exchange(arr, i, max);
			heapify(arr, max, size);
		}
	}

	public static void exchange(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void heapSort(int[] arr, Results result, String arrayType) {
		double startTime = System.currentTimeMillis();
		buildheap(arr);
		int sizeOfHeap = arr.length - 1;
		for (int i = sizeOfHeap; i > 0; i--) {
			count++;
			exchange(arr, 0, i);
			sizeOfHeap = sizeOfHeap - 1;
			heapify(arr, 0, sizeOfHeap);
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

	public ResultList testHeapSort(int[] randomArr, int[] increasingArr, int decreasingArr[],
			HashMap<String, ResultList> finalResults) {

		Results testResults = new Results();
		testResults.setArraySize(randomArr.length);
		heapSort(randomArr, testResults, Random);
		heapSort(increasingArr, testResults, increasing);
		heapSort(decreasingArr, testResults, decreasing);

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
