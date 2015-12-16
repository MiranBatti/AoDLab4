package se.hig.aod.lab4;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.Random;

public class QuickSortMedianOfThree {
	
	public static <T extends Comparable<? super T>> void sort(T[] arr) {
		int low = 0;
		int high = arr.length - 1;
		System.out.println("State 0" + Arrays.toString(arr));
		
		quickSortWorker(arr, low, high);
	}
	
	private static <T extends Comparable<? super T>> void quickSortWorker(T[] arr, int low, int high) {
		if(low < high) {
			int pivot = partition2(arr, low, high);
			
			quickSortWorker(arr, low, pivot - 1);
			quickSortWorker(arr, pivot + 1, high);
		}
		manualSort(arr, low, high);
		System.out.println(Arrays.toString(arr));		
	}
	
	private static <T extends Comparable<? super T>> int partition(T[] arr, int low, int high) {
		Random rnd = new Random();
		int pivotIndex = rnd.nextInt(arr.length - 1);
		T pivot = arr[pivotIndex];
		
		swap(arr, pivotIndex, high);
		
		pivotIndex = high;
		int i = low - 1;
		
		for (int j = low; j < high - 1; j++) {
			int retval = arr[j].compareTo(pivot);
			if(arr[j].compareTo(pivot) <= 0) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, pivotIndex);
		
		return i + 1;
	}
	
	private static<T extends Comparable<? super T>> int partition2(T[] arr, int low, int high) {
		int middle = medianOfThree(arr, low, high);
		
		swap(arr, middle, high - 1);
		T pivot = arr[high - 1];
		
		int i = low;
		int j = high - 1;
		boolean isFinished = false;
		
		while(!isFinished) {
			if(j - 1 < 0)
				j = 1;
			if(i + 1 >= arr.length - 1)
				i = arr.length - 1;
			
			while(arr[++i].compareTo(pivot) < 0);
			while(pivot.compareTo(arr[--j]) < 0);
			
			if(i >= j) {
				isFinished = true;
				break;
			}
			swap(arr, i, j);
		}
		swap(arr, i, high - 1);
		System.out.println(Arrays.toString(arr));	
		
		return i;
	}
	
	private static<T extends Comparable<? super T>> void swap(T[] arr, int pivotIndex, int right) {
		T tmp = arr[pivotIndex];
		arr[pivotIndex] = arr[right];
		arr[right] = tmp;
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
	
	private static<T extends Comparable<? super T>> void manualSort(T[] arr, int left, int right) {
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
	}
}
