import java.util.Random;


/**
 * Alex Simons Siu851287084 CS200 Data Structures Lab5
 */

public class BinaryImplementation {

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
		System.out.println("This is the unsorted array:");
		for(int i=0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println("This is the sorted array: ");
		BinaryRadixSort sorter = new BinaryRadixSort();
		sorter.binaryRadixSort(array);
		for(int i=0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		}

}
