package myTask;


public class Passenger {

	private String name;
	private int age;
	private Gender genderType;
	private berthPrefrence preference;
	private Ticket ticket;
	private boolean havingChild;
	private String childName;
	private Gender childgenderType;
	private int childAge;
	
	
	public Gender getChildgenderType() {
		return childgenderType;
	}
	public void setChildgenderType(Gender childgenderType) {
		this.childgenderType = childgenderType;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public int getChildAge() {
		return childAge;
	}
	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}
	public boolean isHavingChild() {
		return havingChild;
	}
	public void setHavingChild(boolean havingChild) {
		this.havingChild = havingChild;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return genderType;
	}
	public void setGender(Gender gender) {
		this.genderType = gender;
	}
	public berthPrefrence getBerthPreference() {
		return preference;
	}
	public void setBerthPreference(berthPrefrence berthPreference) {
		this.preference = berthPreference;
	}


   public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}



	enum Gender
	{
		MALE,FEMALE;
	}
	public enum berthPrefrence
	{
		LOWER,MIDDLE,UPPER;
	}

}
