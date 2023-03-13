package jpa.entitymodels;

import java.util.List;
import java.util.Scanner;

public class SmsMain {
	
	CourseDAO courseDao = new CourseDAO();
	StudentDAO studentDao = new StudentDAO();
	StudentCourseDAO scDao = new StudentCourseDAO();
	Scanner scan = new Scanner(System.in);
	private Student student;

	public static void main(String[] args) {
		SmsMain sm = new SmsMain();
		
		sm.run();
		
//		sm.getAllStudents();
//		sm.getStudentByEmail(test@test.com);
//		sm.validateStudent();
//		sm.registerStudentToCourse();
//		sm.getStudentCourses();
//		sm.getAllCourses();

	}
	
	private void run() {
		//save selection of 1 or 2 from first prompt
		switch(firstMenuPrompt()) {
		case 1:
			System.out.println("Enter your email address:");
			String email = scan.next();
			System.out.println("Enter your password:");
			String password = scan.next();
			if(studentDao.validateStudent(email, password) != -1) {
				student = studentDao.findByEmail(email);
				List <StudentCourse> courses = scDao.getStudentCourses(studentDao.validateStudent(email, password));
				System.out.println("My Classes:");
				System.out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
				for (StudentCourse course : courses) {
					System.out.println(course);
				}
				registerMenu();
			}
			break;
		case 2:
			System.out.println("Goodbye!");
			System.exit(0);
			break;
		default:
		}
			
	}
		

	private int firstMenuPrompt() {
		System.out.println("Are you a student?\n1. Student\n2. Quit\nPlease enter 1 or 2:");
		int firstSelection = scan.nextInt();
		return firstSelection;
	}
	
	private void registerMenu() {
		System.out.println("1.Register to Class\n2.Logout\nPlease enter your selection:");
		int registerSelection = scan.nextInt();
		
		switch(registerSelection) {
		case 1:
			List<Course> allCourses = courseDao.getAllCourses();
			List<StudentCourse> studentCourses = scDao.getStudentCourses(student.getId());
			System.out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
			for (Course course : allCourses) {
				System.out.println(course);
			}
			System.out.println();
			System.out.print("Enter Course Number: ");
			int number = scan.nextInt();
			Course newCourse = courseDao.findById(number);
			
			for(int i = 0; i < studentCourses.size(); i++) {
				if(number == studentCourses.get(i).getCourseId()) {
					System.out.println("You are already registered in that course!");
					System.exit(0);
				}
			}
			
			 if (newCourse != null) {
				StudentCourseDAO scDao1 = new StudentCourseDAO();
				Student tempStudent = studentDao.findByEmail(student.getEmail());
				scDao.registerStudentToCourse(tempStudent, newCourse);
				List<StudentCourse> sCourses = scDao1.getStudentCourses(tempStudent.getId());
				
				System.out.println("My Classes:");
				System.out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
				for (StudentCourse course: sCourses) {
					System.out.println(course);
				}
			}
			break;
			
		case 2:
		default:
			System.out.println("Goodbye!");
			System.exit(0);
		}
				
	}
	
	
}
