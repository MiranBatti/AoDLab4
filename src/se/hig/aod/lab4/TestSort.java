package se.hig.aod.lab4;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.Random;;

public class TestSort {
	public static void main(String[] args) {
//		Integer[] indata = (Integer[]) new Comparable[10];
		Integer[] indata = new Integer[10];
		Random rnd = new Random();
		
		for (int i = 0; i < indata.length; i++) {
			indata[i] = rnd.nextInt(indata.length);
		}
		
		indata[0] = 3;
		indata[1] = 2;
		indata[2] = 7;
		indata[3] = 8;
		indata[4] = 4;
		indata[5] = 9;
		indata[6] = 5;
		indata[7] = 6;
		indata[8] = 1;
		indata[9] = 10;
		
		QuickSortMedianOfThree.sort(indata);
		System.out.println("Slut " + Arrays.toString(indata));
	}
}
