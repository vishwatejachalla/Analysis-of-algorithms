
package com.java.sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.java.commonutils.Utility;
import com.java.domain.ResultList;
import com.java.domain.Results;

public class QuickSort {

	private static String algorithm = "QUICK";
	private static String Random = "RANDOM";
	private static String increasing = "INCREASING";
	private static String decreasing = "DECREASING";
	static Utility util = new Utility();
	private static int count = 0;
	private static int array[];

	public static void main(String a[]) {
		int[] input = { 33, 21, 45, 64, 55, 34, 11, 8, 3, 5, 1 };
		System.out.println("Before Sorting : ");
		System.out.println(Arrays.toString(input));
		sort(input);
		System.out.println("==================");
		System.out.println("After Sorting : ");
		System.out.println(Arrays.toString(array));

	}

	public static void sort(int[] arr) {
		quickSort(0, arr.length - 1);
	}

	public void sort(int[] arr, Results result, String arrayType) {
		array = arr;
		double startTime = System.currentTimeMillis();
		quickSort(0, arr.length - 1);
		double EndTime = ((System.currentTimeMillis() - startTime) / 1000);
		System.out.println("count :: " + count);
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
		util.printArryAsMatrix(arr);

	}

	private static void quickSort(int left, int right) {
		count++;
		int i = left;
		int j = right;
		int pivot = array[right];
		while (i <= j) {

			while (array[i] < pivot || array[j] > pivot) {
				if (array[i] < pivot) {
					i++;
				}
				if (array[j] > pivot) {
					j--;
				}
			}

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		if (left < j)
			quickSort(left, j);
		if (i < right)
			quickSort(i, right);
	}

	private static void exchange(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public ResultList testQuickSort(int[] randomArr, int[] increasingArr, int decreasingArr[],
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
