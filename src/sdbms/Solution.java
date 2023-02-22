package sdbms;

import java.util.Scanner;

import custom_exception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		StudentManagemenSystem sms=new StudentManagemenSystemImpl();
		while(true) {
			System.out.println("1:Add Student \n 2:display students \n 3:display all students");
			System.out.println("4:remove students \n 5: remove all students \n 6:update student \n 7:count student");
			System.out.println("8:sort student \n 9:get Student by lowest marks \n 10:get Student by highest marks \n 11:exit");

			System.out.println("<<<<<<<------------------------>>>>>>>");
			System.out.println("enter your choice");
			int choice=ip.nextInt();

			switch (choice) {
			case 1:
				sms.addStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 2:
				sms.displayStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 3:
				sms.displayAllStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 4:
				sms.removeStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 5:
				sms.removeAllStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 6:
				sms.updateStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 7:
				sms.countStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 8: 
				sms.sortStudent();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 9:
				sms.getStudentWithLowestMarks();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 10:
				sms.getStudentWithHighestMarks();
				System.out.println("<<<<<<<------------------------>>>>>>>");
				break;

			case 11:
				System.out.println("thank you");
				System.exit(0);

			default:
				try {
					throw new InvalidChoiceException ("invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}//end of switch

		}//end of while loop
	}//end of main method
} //end of class

