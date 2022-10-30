package batchupdate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("batchupdate.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

//		List<Student> initialStudents = studentJDBCTemplate.listStudents();
//		System.out.println("Inserted Students");

		Student student = new Student();
		student.setId(1);
		student.setAge(28);
//		student.setName("Ravi");

		Student student1 = new Student();
		student1.setId(2);
		student1.setAge(27);
		student1.setName("Pandian");

		List<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student1);
//		studentJDBCTemplate.batchInsert(students);

		studentJDBCTemplate.batchUpdate(students);

		List<Student> updatedStudents = studentJDBCTemplate.listStudents();
		System.out.println("Updated Students");

		for (Student student3 : updatedStudents) {
			System.out.print("ID : " + student3.getId());
			System.out.println(", Age : " + student3.getAge());
		}
	}

}
