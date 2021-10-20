package com.java.commonutils;

public class Utility {

	public void printArryAsMatrix(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; ++i) {
			count++;

			if (count == 10) {
				count = 0;
				System.out.printf("%7d", arr[i]);
				System.out.println();
			} else {
				System.out.printf("%7d", arr[i]);
			}

		}
	}

}
