import java.util.Scanner;


public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the 2 student names.");		
		Student student1 = new Student("Mary");
		Student student2 = new Student("Mike");
		student1.inputGrades();
		student2.inputGrades();
		System.out.println("Student name: " + student1.getName());
		System.out.println(student1.getName() + "'s average: " + student1.getAverage());
		System.out.println("Student name: " + student2.getName());
		System.out.println( student2.getName() +"'s  average: " + student2.getAverage());
	}

}
