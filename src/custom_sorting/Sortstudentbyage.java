package custom_sorting;

import java.util.Comparator;

import sdbms.Student;

public class Sortstudentbyage implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getAge()-y.getAge();
	}

}
