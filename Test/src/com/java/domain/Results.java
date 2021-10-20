package com.java.domain;

public class Results {

	private int arraySize;
	private double incOrderTime;
	private double decOrderTime;
	private double randomOrderTime;
	private int incOrderCount;
	private int decOrderCount;
	private int randomOrderCount;

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public double getIncOrderTime() {
		return incOrderTime;
	}

	public void setIncOrderTime(double incOrderTime) {
		this.incOrderTime = incOrderTime;
	}

	public double getDecOrderTime() {
		return decOrderTime;
	}

	public void setDecOrderTime(double decOrderTime) {
		this.decOrderTime = decOrderTime;
	}

	public double getRandomOrderTime() {
		return randomOrderTime;
	}

	public void setRandomOrderTime(double randomOrderTime) {
		this.randomOrderTime = randomOrderTime;
	}

	public void setRandomOrderTime(int randomOrderTime) {
		this.randomOrderTime = randomOrderTime;
	}

	public int getIncOrderCount() {
		return incOrderCount;
	}

	public void setIncOrderCount(int incOrderCount) {
		this.incOrderCount = incOrderCount;
	}

	public int getDecOrderCount() {
		return decOrderCount;
	}

	public void setDecOrderCount(int decOrderCount) {
		this.decOrderCount = decOrderCount;
	}

	public int getRandomOrderCount() {
		return randomOrderCount;
	}

	public void setRandomOrderCount(int randomOrderCount) {
		this.randomOrderCount = randomOrderCount;
	}

	@Override
	public String toString() {
		return incOrderTime + " " + decOrderTime + " " + randomOrderTime;
	}

}
