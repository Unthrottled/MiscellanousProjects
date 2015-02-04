/**
 * Alex Simons Siu851287084 CS200 Data Structures Lab5
 */


import java.util.Random;


public class DecimalImplementation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 10;
		Random num = new Random();
		int array[] = new int[size];
		
		for(int i=0; i<array.length;i++){
			array[i] = num.nextInt(1000);
		}
		System.out.println("This is the unsorted array: ");
		for(int i=0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println("This is the sorted array: ");
		DecimalRadixSort sorter = new DecimalRadixSort();
		sorter.decimalRadixSort(array);
		for(int i=0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}

}
