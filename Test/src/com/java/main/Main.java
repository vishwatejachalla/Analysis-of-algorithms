package com.java.main;

import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import com.java.commonutils.Utility;
import com.java.domain.ResultList;
import com.java.domain.Results;
import com.java.sortings.BubbleSort;
import com.java.sortings.BubbleSortReverse;
import com.java.sortings.HeapSort;
import com.java.sortings.InsertionSort;
import com.java.sortings.InsertionSortModified;
import com.java.sortings.MergeSort;
import com.java.sortings.QuickSort;
import com.java.sortings.RandomizedQuickSort;
import com.java.sortings.SelectionSort;

public class Main {

	private static String bubble_sort = "BUBBLE";
	private static String selection_sort = "SELECTION";
	private static String insertion_sort = "INSERTION";
	private static String modified_Insertion_sort = "MODIFIED INSERTION";
	private static String merge_sort = "MERGE";
	private static String quick_sort = "QUICK";
	private static String random_quick_sort = "RANDOMIZED QUICK";
	private static String heap_sort = "HEAP";

	Utility util = new Utility();

	private void testAllSprtings() {

		Random rd = new Random();
		HashMap<String, ResultList> finalResults = new HashMap<>();
		double startTime = System.currentTimeMillis();
		int count = 0;
		for (int j = 0; j < 4; j++) {
			int listSize = 100;

			if (count == 0) {
				listSize = 100;
			} else if (count == 1) {
				listSize = 1000;
			} else if (count == 2) {
				listSize = 10000;
			} else if (count == 3) {
				listSize = 30000;
			}

			count++;
			int[] randomArry = new int[listSize];
			int[] increasingArry = new int[listSize];
			int[] decreasingArry = new int[listSize];
			for (int i = 0; i < listSize; ++i) {

				randomArry[i] = rd.nextInt(30000);

			}
			increasingArry = randomArry;
			Arrays.sort(increasingArry);
			// util.printArryAsMatrix(randomArry);
			BubbleSortReverse bubbleSortReverse = new BubbleSortReverse();
			decreasingArry = bubbleSortReverse.bubbleSort(randomArry);

			ResultList result = new ResultList();

			HeapSort heapSort = new HeapSort();
			result = heapSort.testHeapSort(randomArry, increasingArry, decreasingArry, finalResults);
			finalResults.put(heap_sort, result);

			MergeSort mergeSort = new MergeSort();
			result = mergeSort.testMergeSort(randomArry, increasingArry, decreasingArry, finalResults);
			finalResults.put(merge_sort, result);

			RandomizedQuickSort randomQuickSort = new RandomizedQuickSort();
			result = randomQuickSort.testRandomQuickSort(randomArry, increasingArry, decreasingArry, finalResults);
			finalResults.put(random_quick_sort, result);

			/*
			 * QuickSort quickSort = new QuickSort(); result =
			 * quickSort.testQuickSort(randomArry, increasingArry, decreasingArry,
			 * finalResults); finalResults.put(quick_sort, result);
			 */
			InsertionSortModified modifiedInsertionSort = new InsertionSortModified();
			result = modifiedInsertionSort.testModifiedInsertionSort(randomArry, increasingArry, decreasingArry,
					finalResults);
			finalResults.put(modified_Insertion_sort, result);

			InsertionSort insertionSort = new InsertionSort();
			result = insertionSort.testInsertionSort(randomArry, increasingArry, decreasingArry, finalResults);
			finalResults.put(insertion_sort, result);

			BubbleSort bubblesort = new BubbleSort();
			result = bubblesort.testBubbleSort(randomArry, increasingArry, decreasingArry, finalResults);
			finalResults.put(bubble_sort, result);

			SelectionSort selectionSort = new SelectionSort();
			result = selectionSort.testSelectionSort(randomArry, increasingArry, decreasingArry, finalResults);
			finalResults.put(selection_sort, result);

		}
		ResultList result = null;
		Formatter f = new Formatter();
		f.format(
				"-----------------------------------------------------------------------------------------------------------------\n");
		f.format("%15s %21s %21s %22s %21s\n", "|  Array Size          |", "100 |", "1000 |", "10000 |", "30000 |");
		f.format(
				"-----------------------------------------------------------------------------------------------------------------\n");
		f.format("%15s %6s %6s %7s %6s %6s %7s %6s %7s %7s %6s %6s %7s\n", "|  Array Type          |", "inc|", "dec|",
				"ran|", "inc|", "dec|", "ran |", "inc|", "dec|", "ran |", "inc|", "dec|", "ran |");

		for (String key : finalResults.keySet()) {
			result = finalResults.get(key);
			String sortName = result.getAlgorithmName();
			int maxSortName = 20;
			int minSortName = 0;
			int diff = maxSortName - sortName.length();
			int diff1 = minSortName + sortName.length();
			f.format(
					"\n-----------------------------------------------------------------------------------------------------------------\n");
			f.format("%" + diff1 + "s ", "|  " + result.getAlgorithmName());
			f.format("%" + diff + "s ", "|");
			for (Results results : result.getResults()) {
				f.format("%6s %6s %7s ", results.getIncOrderTime() + "|", results.getDecOrderTime() + "|",
						results.getRandomOrderTime() + " |");
			}
		}

		System.out.println(f);

		Formatter fc = new Formatter();
		fc.format(
				"-----------------------------------------------------------------------------------------------------------------\n");
		fc.format("%15s %21s %21s %22s %21s\n", "|  Array Size          |", "100 |", "1000 |", "10000 |", "30000 |");
		fc.format(
				"-----------------------------------------------------------------------------------------------------------------\n");
		fc.format("%15s %6s %6s %7s %6s %6s %7s %6s %7s %7s %6s %6s %7s\n", "|  Array Type          |", "inc|", "dec|",
				"ran|", "inc|", "dec|", "ran |", "inc|", "dec|", "ran |", "inc|", "dec|", "ran |");

		for (String key : finalResults.keySet()) {
			result = finalResults.get(key);
			String sortName = result.getAlgorithmName();
			int maxSortName = 20;
			int minSortName = 0;
			int diff = maxSortName - sortName.length();
			int diff1 = minSortName + sortName.length();
			fc.format(
					"\n-----------------------------------------------------------------------------------------------------------------\n");
			fc.format("%" + diff1 + "s ", "|  " + result.getAlgorithmName());
			fc.format("%" + diff + "s ", "|");
			for (Results results : result.getResults()) {
				fc.format("%6s %6s %7s ", results.getIncOrderCount() + "|", results.getDecOrderCount() + "|",
						results.getRandomOrderCount() + " |");
			}
		}

		System.out.println(fc);

		double EndTime = ((System.currentTimeMillis() - startTime) / 1000);

		System.out.println("end time" + EndTime);
		System.out.println("date" + new Date());

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------- User menu  -------------------------");
		System.out.println("1. SELECTION SORT");
		System.out.println("2. BUBBLE SORT");
		System.out.println("3. INSERTION SORT");
		System.out.println("4. MODIFIED INSERTION SORT");
		System.out.println("5. MERGE SORT");
		System.out.println("6. QUICK SORT");
		System.out.println("7. RANDOMIZED QUICK SORT");
		System.out.println("8. HEAP SORT");
		System.out.println("9. HEAP SORT");
		System.out.println("--------------------- End of user Menu ---------------------");
		
		System.out.println("please enter the option");
		
		
	}
}
