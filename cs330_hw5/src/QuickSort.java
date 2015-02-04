
/**
 *Alex Simons 
 *CS330
 *HW5 
 *11/11/2013
 */


import java.util.*;
import java.io.*;

public class QuickSort {
    private static int[] array;
	
    public static void main(String[] args) {
    	System.out.println("How many numbers do you want to input?");
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	input.nextLine();
        array = new int[n];
    	System.out.println("Please enter " + n +" numbers (format: \"number\" \"number\".....\"number\")");//"45 23 1 5....645"
    	for(int i =0; i<array.length;i++){
    		int j = input.nextInt();;
    		array[i] = j;
    	}
    	input.nextLine();
    	quickSort(0,array.length-1);
    	for(int i =0; i<array.length;i++){
    		System.out.print(array[i] + " ");
    	}
        
    }
	private static void quickSort(int l, int r){
	  if (l < r){
	    int s = partition(l,r);
		quickSort(l,s-1);
		quickSort(s+1,r);
	  }
	}
	
	private static int partition(int l, int r){
	  int pivot = array[l];
	  while(l<r){
		  while (array[l] < pivot) l++;
	      while (array[r] > pivot) r--;
	      swap(l,r);
	  }
	  return r;
	}
	
	private static void swap(int i, int j){
	  int temp = array[i];
	  array[i] = array[j];
	  array[j] = temp;
	}
}
