import java.util.Scanner;


public class Grades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int grade1, grade2;
		System.out.println("Please enter the student's name.");
		String name = keyboard.nextLine();
		Student student1 = new Student(name);
		System.out.println("Please insert two test grades.");
		grade1 = keyboard.nextInt();
		grade2 = keyboard.nextInt();
		student1.setGrades(grade1, grade2);
		System.out.println("Student name: " + student1.getName());
		System.out.println("Student average: " + student1.getAverage());
	}

}
