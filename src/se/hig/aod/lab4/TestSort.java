package se.hig.aod.lab4;

import java.lang.Comparable;
import java.util.Random;;

public class TestSort {
	public static void main(String[] args) {
//		Integer[] indata = (Integer[]) new Comparable[10];
		Integer[] indata = new Integer[10];
		Random rnd = new Random();
		
		for (int i = 0; i < indata.length; i++) {
			indata[i] = rnd.nextInt(indata.length);
		}
		
		QuickSort.sort(indata);
	}
}
