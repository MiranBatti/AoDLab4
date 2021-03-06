package se.hig.aod.lab4;

import java.lang.Comparable;
import java.util.Arrays;

/**
 * 
 * @author Miran Batt
 * @author Fredrik Lindorf
 * 
 * @version 2015-12-17
 *
 */
public class QuickSortMedianOfThree {
	
	private static int state = 0; // används för att se varje steg i sorteringen.
	
	public static <T extends Comparable<? super T>> void sort(T[] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("Array is empty. Cannot sort.");
		    return;
		    }
		
		int low = 0;
		int high = arr.length - 1;
		state = 0;
//		callPrinter(arr);
		
		quickSortWorker(arr, low, high);
	}
	
	private static <T extends Comparable<? super T>> void quickSortWorker(T[] arr, int low, int high) {
		if(low < high) {
			int pivot = partition(arr, low, high);
			
			quickSortWorker(arr, low, pivot - 1);
			quickSortWorker(arr, pivot + 1, high);
		}
		manualSort(arr, low, high);
	}
	
	private static<T extends Comparable<? super T>> int partition(T[] arr, int low, int high) { // Hoare baserat partition
		int middle = medianOfThree(arr, low, high);
		
		swap(arr, middle, high - 1);
//		callPrinter(arr);
		T pivot = arr[high - 1];
		
		int i = low;
		int j = high - 1;
		boolean isFinished = false;
		
		while(!isFinished) {
			// if satser till för dubbletter
			if(j - 1 <= 0)
				j = 1;
			if(i + 1 > arr.length - 1)
				i = arr.length - 1;
			
			while(arr[++i].compareTo(pivot) < 0);
			
			while(pivot.compareTo(arr[--j]) < 0);
			
			if(i >= j) {
				isFinished = true;
				break;
			}
			swap(arr, i, j);
//			callPrinter(arr);
		}
		swap(arr, i, high - 1);
//		callPrinter(arr);
		
		return i;
	}
	
	private static<T extends Comparable<? super T>> void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private static<T extends Comparable<? super T>> int medianOfThree(T[] arr, int left, int right) {
		int middle = (left + right) / 2;

		if (arr[middle].compareTo(arr[left]) < 0)
			swap(arr, left, middle);
		if (arr[right].compareTo(arr[left]) < 0)
			swap(arr, left, right);
		if (arr[right].compareTo(arr[middle]) < 0)
			swap(arr, middle, right);

		return middle;
	}
	
	private static<T extends Comparable<? super T>> void manualSort(T[] arr, int left, int right) { // kod taget från: http://www.java2s.com/Tutorial/Java/0140__Collections/Quicksortwithmedianofthreepartitioning.htm
		int size = right - left + 1;
		
		if(size <= 1)
			return;
		if(size == 2) {
			if(arr[left].compareTo(arr[right]) >= 0) 
				swap(arr, left, right);
			return;
		} else {
			if(arr[left].compareTo(arr[right - 1]) >= 0)
				swap(arr, left, right - 1);
			if (arr[left].compareTo(arr[right]) >= 0)
		        swap(arr, left, right);
		      if (arr[right - 1].compareTo(arr[right]) >= 0)
		        swap(arr, right - 1, right);
		}
//		callPrinter(arr);
	}
	
	private static<T extends Comparable<? super T>> void callPrinter(T[] arr) {
		System.out.println(state++ + ": " + Arrays.toString(arr));
	}
}
