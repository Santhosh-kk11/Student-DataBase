package sdbms;

public class Student {
	private String id;
	private int age;
	private String name;
	private int marks;
	
	static int count=101;

	Student(int age,String name,int marks){
		this.id="1KI"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}

	public void setAge(int age) {
		this.age=age;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setMarks(int marks) {
		this.marks=marks;
	}

	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getMarks() {
		return marks;
	}

	public String toString() {
		return "id is "+id+" age is "+age+" name is "+name+" marks "+marks;
	}
}
