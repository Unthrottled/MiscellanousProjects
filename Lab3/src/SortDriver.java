import java.util.*;
import java.io.*;

public class QuickSort {
    private static int[] array;
	
    public static void main(String[] args) {
        
    }
	private void quickSort(int l, int r){
	  if l < r{
	    int s = partition(l,r);
		quickSort(l,s-1);
		quickSort(s+1,r);
	  }
	}
	
	private int partition(int l, int r){
	  int pivot = array[0];
	  int i,j;
	  i = 0;
	  j = array.length() -1;
	  do{
	    while(array[i]<=pivot)
		  i++;
		while(array[j]>=pivot)
		  j--;
		swap(i,j);
	  }while(i>=j);
      swap(i,j);
	  swap(0,j);
	  return j;
	}
	
	private void swap(int i, int j){
	  int temp = array[i];
	  array[i] = array[j];
	  array[j] = temp;
	}
}