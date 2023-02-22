package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import custom_exception.StudentNotFoundException;
import custom_sorting.SortStudentbyId;
import custom_sorting.SortStudentbyname;
import custom_sorting.Sortstudentbyage;
import custom_sorting.Sortstudentbymarks;

public class StudentManagemenSystemImpl implements StudentManagemenSystem {

	Scanner ip=new Scanner(System.in);

	Map<String,Student> db=new LinkedHashMap();


	@Override
	public void addStudent() {
		System.out.println("enter the Student age");
		int age=ip.nextInt();
		System.out.println("enter the Student name");
		String name=ip.next();
		System.out.println("enter the Student marks");
		int marks=ip.nextInt();

		Student std=new Student(age, name, marks);
		db.put(std.getId(),std);
		System.out.println("Student data added succesfully");
		System.out.println("Student id is "+std.getId());

	}

	@Override
	public void displayStudent() {
		System.out.println("enter the Student id");
		String id=ip.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student student=db.get(id);

			System.out.println("name:"+student.getName());
			System.out.println("age:"+student.getAge());
			System.out.println("marks:"+student.getMarks());
			//System.out.println(std);
		}
		else
		{
			try {
				throw new StudentNotFoundException("invalid id");
			}
			catch(Throwable e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			Set<String> keys=db.keySet();
			for(String key:keys) {
				//Student value=db.get(key);
				//System.out.println(value);
				System.out.println(db.get(key));  

			}
		}
		else{
			try {
				String message="first enter the Student data";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}

	}

	@Override
	public void removeStudent() {
		System.out.println("enter the id");
		String id=ip.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("student record found");

			db.remove(id);
			System.out.println("student record deleted Sucessfully");

		}
		else 
		{
			try {
				String message="student with the id: "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}


	}

	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("student record available: "+db.size());
			db.clear();
			System.out.println("all the Student record deleted Sucessfully");
			System.out.println("student record available: "+db.size());
		}
		else

		{
			try {
				throw new StudentNotFoundException("there is no student data found to delete");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}


	@Override
	public void updateStudent() {
		System.out.println("enter the Student id");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:update age \n 2:update name \n 3:update marks ");
			System.out.println("enter your choice");
			int choice=ip.nextInt();

			switch (choice) {
			case 1:
				System.out.println("enter age");
				int age =ip.nextInt();
				std.setAge(age);
				break;

			case 2:
				System.out.println("enter the name");
				String name=ip.next();
				std.setName(name);
				break;

			case 3:
				System.out.println("enter the marks");
				int marks=ip.nextInt();
				std.setMarks(marks);
				break;

			default:
				try {
					throw new StudentNotFoundException("invalid student id");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}


	}

	@Override
	public void countStudent() {
		System.out.println("no of Student record "+db.size());

	}

	@Override
	public void sortStudent() {
		if(db.size()>=2) {
		Set<String>keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}

		System.out.println(" 1:Sort Student by id \n 2:sort student by age \n 3:sort student by name \n 4:sort student by marks");
		System.out.println("enter your choice");
		int choice =ip.nextInt();

		switch(choice) {

		case 1:
			Collections.sort(list ,new SortStudentbyId());
			for(Student s:list) {
				System.out.println(s);
				
			}
			break;

		case 2:
			Collections.sort(list, new Sortstudentbyage());
			for(Student s:list) {
				System.out.println(s);
				}
			break;
		case 3:
			Collections.sort(list,new SortStudentbyname());
			for(Student s:list) {
				System.out.println(s);
				}
			break;
		case 4:
			Collections.sort(list ,new Sortstudentbymarks());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
			default:
				System.out.println("invalid choice");
		}
		}
		else {
			try {
				throw new StudentNotFoundException("invalid choice");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
		Set<String>keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
				for(String key:keys) {
					list.add(db.get(key));
				}
				Collections.sort(list ,new Sortstudentbymarks());
				System.out.println(list.get(0));

	}
		else {
			try {
				throw new StudentNotFoundException("no sufficient student object to compare");
			}
			catch(Throwable e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
		Set<String>keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
				for(String key:keys) {
					list.add(db.get(key));
				}
				Collections.sort(list ,new Sortstudentbymarks());
				System.out.println(list.get(list.size()-1));
	}
		else
		{
			try {
				throw new StudentNotFoundException("no sufficient student object to compare");
			}
			catch(Throwable e) {
				System.out.println(e.getMessage());
			}
		}
	}


}
