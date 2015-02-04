
public class Name {
	private String firstName;
	private String middleName;
	private String lastName;
	
	public void Name(String first, String middle, String last){
		this.firstName=first;
		this.middleName=middle;
		this.lastName=last;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getMiddleName(){
		return middleName;
	}
	public String getLastName(){
		return lastName;
	}
	public void firstMiddleLast(){
		System.out.println(getFirstName()+" "+ getMiddleName() +" "+ getLastName());
	}
	public void lastMiddleFirst(){
		System.out.println(getLastName()+", "+ getMiddleName()+" "+ getFirstName());
	}
	public boolean equal(Name otherName){
		return (this.firstName.equalsIgnoreCase(otherName.firstName))&&
				(this.middleName.equalsIgnoreCase(otherName.middleName))&&
				(this.lastName.equalsIgnoreCase(otherName.lastName));
	}
	public void getInitials(){
		String first= substring(0, 1); 
		String middle= substring(0, 1);
		String last= substring(0, 1);
		System.out.println(first.toUpperCase()+middle.toUpperCase()+last.toUpperCase());
	}
	private String substring(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getNameLength(){
		int firstLenght = firstName.length();
		int secondLenght = middleName.length();
		int lastLenght = lastName.length();
		int lenght = firstLenght + secondLenght + lastLenght;
		return lenght;
	}
	
}
