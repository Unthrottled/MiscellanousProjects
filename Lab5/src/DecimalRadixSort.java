/**
 * Alex Simons Siu851287084 CS200 Data Structures Lab5
 */
public class DecimalRadixSort{
	private int[] bucket0 = new int[10];
	private int[] bucket1 = new int[10];
	private int[] bucket2 = new int[10];
	private int[] bucket3 = new int[10];
	private int[] bucket4 = new int[10];
	private int[] bucket5 = new int[10];
	private int[] bucket6 = new int[10];
	private int[] bucket7 = new int[10];
	private int[] bucket8 = new int[10];
	private int[] bucket9 = new int[10];
	
	//returns the appropriate number for the current sort
	private static int getNum(int num, int count){
		int[] dec = new int[4];
		for(int i = 0; i<4; i++){
			if(num<10&& i==3){
				dec[i]=num;
			}
			else if(num<10 && num != 0){
				dec[i] = num%10;
				num = num/10;
			}
			else if(num>10){
				dec[i]= num%10;
				num = num/10;
			}
			else{
				num = 0;
				dec[i] = num;
			}
		}
			
		return dec[count];
		}
	
	//clears the bucket by replacing all numbers of the array with -1
	private void clear(int[] a){
		for(int i = 0; i<a.length; i++){
			a[i]=-1;
		}
	}
	
	//finds the end of the array and returns the value
	//used to find the end of a certain bucket
	private static int endArray(int[] a){
		int count = 0; 
		while(a[count] != -1){
			count++;
		}
		return count;
	}
	
	//sorts the array that it is given
	public  void decimalRadixSort(int[]a){
		int count = 0;
		for(int i = 0; i<3; i++){
			clear(bucket0); 
			clear(bucket1);	
			clear(bucket2);
			clear(bucket3);
			clear(bucket4);
			clear(bucket5);
			clear(bucket6);
			clear(bucket7);
			clear(bucket8);
			clear(bucket9);
			for(int j = 0; j<a.length; j++){
				int digit = getNum(a[j], count);
				if(digit ==1)
					bucket1[endArray(bucket1)]=a[j];
				else if(digit ==2)
					bucket2[endArray(bucket2)]=a[j];
				else if(digit ==3)
					bucket3[endArray(bucket3)]=a[j];
				else if(digit ==4)
					bucket4[endArray(bucket4)]=a[j];
				else if(digit ==5)
					bucket5[endArray(bucket5)]=a[j];
				else if(digit ==6)
					bucket6[endArray(bucket6)]=a[j];
				else if(digit ==7)
					bucket7[endArray(bucket7)]=a[j];
				else if(digit ==8)
					bucket8[endArray(bucket8)]=a[j];
				else if(digit ==9)
					bucket9[endArray(bucket9)]=a[j];
				else
					bucket0[endArray(bucket0)]=a[j];
			}
			boolean done = false;
			int place = 0;
			while(place<10&&!done){
			if(bucket0[place] != -1){
				a[place]=bucket0[place];
				place++;
			}
			else
				done=true;
			}
			done = false;
			int place2 = 0;
			while(place<10&&!done){
			if(bucket1[place2] !=-1){
				a[place]=bucket1[place2];
				place++;
				place2++;
			}
			else
				done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket2[place2] !=-1){
				a[place]=bucket2[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket3[place2] !=-1){
				a[place]=bucket3[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket4[place2] !=-1){
				a[place]=bucket4[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket5[place2] !=-1){
				a[place]=bucket5[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket6[place2] !=-1){
				a[place]=bucket6[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket7[place2] !=-1){
				a[place]=bucket7[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket8[place2] !=-1){
				a[place]=bucket8[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			done = false;
			place2 = 0;
			while(place<10&&!done){
				if(bucket9[place2] !=-1&&place<10){
				a[place]=bucket9[place2];
				place++;
				place2++;
			}
				else
					done=true;
			}
			count++;
			
		}
	}
	
	
	
}