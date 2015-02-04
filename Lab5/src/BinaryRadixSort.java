/**
 * Alex Simons Siu851287084 CS200 Data Structures Lab5
 */
public class BinaryRadixSort {
		private int[] bucket0 = new int[10];
		private int[] bucket1 = new int[10];
	
	private static int getBit(int v, int bit){
		int[] a = new int[10];
		int val = v;
		int count = 9;
		while(count !=-1){
			a[count] = val%2;
			val=val/2;
			count--;
			}
		return a[bit];		
		}
	private void clear(int[] a){
		for(int i = 0; i<a.length; i++){
			a[i]=-1;
		}
	}
		
	private static int endArray(int[] a){
		int count = 0; 
		while(a[count] != -1){
			count++;
		}
		return count;
	}
		
	
	public void binaryRadixSort(int[] a){
		int count = 9;
		for(int i = 0; i<a.length; i++){
			clear(bucket0); 
			clear(bucket1);			
			for(int j = 0; j<a.length; j++){
				int digit = getBit(a[j], count);
				if(digit ==1)
					bucket1[endArray(bucket1)]=a[j];
				else
					bucket0[endArray(bucket0)]=a[j];
			}
			int place = 0;
			while(bucket0[place] != -1&&place<10){
				a[place]=bucket0[place];
				place++;
			}
			int place2 = 0;
			while(bucket1[place2] !=-1&&place<10){
				a[place]=bucket1[place2];
				place++;
				place2++;
			}
			count--;
			
		}
		
		
		
		
	}
	
}
