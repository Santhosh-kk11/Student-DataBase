package custom_sorting;

import java.util.Comparator;

import sdbms.Student;

public class Sortstudentbymarks implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getMarks()-y.getMarks();
	}

}
