
package com.java.sortings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.java.commonutils.Utility;
import com.java.domain.ResultList;
import com.java.domain.Results;

public class RandomizedQuickSort {

	private static String algorithm = "RANDOMIZED QUICK";
	private static String Random = "RANDOM";
	private static String increasing = "INCREASING";
	private static String decreasing = "DECREASING";
	static Utility util = new Utility();
	private static int count = 0;
	private static int array[];

	public void sort(int[] arr, Results result, String arrayType) {
		double startTime = System.currentTimeMillis();
		array = arr;
		quickSort(array, 0, array.length - 1);
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

	static void random(int arr[], int low, int high) {

		Random rand = new Random();
		int pivot = rand.nextInt(high - low) + low;

		int temp1 = arr[pivot];
		arr[pivot] = arr[high];
		arr[high] = temp1;
	}

	private static void quickSort(int arr[], int left, int right) {
		count++;
		int i = left;
		int j = right;
		random(arr, left, right);
		int pivot = array[right];

		while (i <= j) {
			// count++;
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		if (left < j)
			quickSort(arr, left, j);
		if (i < right)
			quickSort(arr, i, right);
	}

	private static void exchange(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public ResultList testRandomQuickSort(int[] randomArr, int[] increasingArr, int decreasingArr[],
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
