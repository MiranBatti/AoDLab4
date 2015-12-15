package se.hig.aod.lab4;

import java.util.Arrays;
import java.util.Random;
import java.lang.Comparable;;

public class QuickSort {
	
	public static <T extends Comparable<? super T>> void sort (T[] array) {
		Random rnd = new Random();
		T[] arr = array;
		int length = array.length;
		int left = 0; // first
		int right = length - 1; // last
		int randomPivot = rnd.nextInt(length - 1); // en random int från 0 till arrayens slut.
		
		if(left >= right) // om listan är sorterat
			return;
				
		arr = QuickSort.swap(array, left, randomPivot);
		
//		int pivot = QuickSort.partition(array, left, right);
		
		System.out.println(Arrays.toString(array));
		
		// right sort
		while(left < right) {
			
			while(left <= right && array[left].compareTo(array[randomPivot]) < 0)
				left++;
			
			while(right <= left && array[right].compareTo(array[randomPivot]) >= 0)
				right--; 
			
			if(right >= left)
				swap(array, left, right);
		}
		
		
		
		// left sort
	}
	
	public static <T extends Comparable<? super T>> int partition(T[] array, int left, int right) {
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Comparable[array.length];
		T pivot = array[left];
		
		int i = 0, j = right - left, k;
		
		for (k = left + 1; k <= right; k++) {
			if(array[k].compareTo(pivot) < 0) 
				tmp[i++] = array[k];
			else
				tmp[j--] = array[k];
		}
		
		tmp[i] = array[left];
		
		for (k = left; k <= right; k++) 
			array[k] = tmp[k - left];
		
		return left + i;
	}
	
	public static<T extends Comparable<? super T>> T[] swap(T[] array, int left, int right) {
		T tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
		
		return array;
	}
	
}
