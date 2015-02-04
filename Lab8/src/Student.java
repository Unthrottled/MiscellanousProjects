import java.util.Scanner;


public class Student {
	private String name;
	private double average;
	
	public Student(String studentName){
		this.name = studentName;
	}
	public String getName(){
		return name;
	}
	public void setGrades(int grade1, int grade2){
		int sum = grade1 + grade2;
		int avg = sum/2;
		this.average = avg;
	}
	public void inputGrades(){
		Scanner keyboard = new Scanner(System.in);
		int grade1, grade2, sum;
		double avg; 
		System.out.println("Please insert " + getName() + "'s test grades.");
		grade1 = keyboard.nextInt();
		grade2 = keyboard.nextInt();
		sum = grade1 + grade2;
		avg = sum/2;
		this.average =(double) avg;
		
	}
	public double getAverage(){
		return average;
	}

}
