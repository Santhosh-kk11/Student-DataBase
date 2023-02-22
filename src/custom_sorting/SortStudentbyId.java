package custom_sorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentbyId implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		// TODO Auto-generated method stub
		return x.getId().compareTo(y.getId());
	}

}
