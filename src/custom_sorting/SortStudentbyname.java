package custom_sorting;

import java.util.Comparator;
import sdbms.Student;


public class SortStudentbyname implements Comparator<Student>{

	@Override
	public int compare(Student x, Student y) {
		
		return x.getName().compareTo(y.getName());
	}
	

}
