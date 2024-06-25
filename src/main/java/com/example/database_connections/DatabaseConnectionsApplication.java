package com.example.database_connections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.database_connections.dao.StudentDAO;
import com.example.database_connections.entity.Student;

@SpringBootApplication
public class DatabaseConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseConnectionsApplication.class, args);
	}

	@Bean
	CommandLineRunner abcdefgh(StudentDAO studentDAO) {
		return runner -> {
			// readStudent(studentDAO);
			// getAllStudent(studentDAO);
			// getByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("sachin", "tripathi", "sachin@wecp.in");

		studentDAO.save(student);

		System.out.println("Save student id: " + student.getID());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating students..............");
		Student student1 = new Student("archana", "devi", "arachana+1@wecp.in");
		Student student2 = new Student("pranjal", "gupta", "pranjal@ciranomy.in");
		Student student3 = new Student("akshat", "sri", "akshat@optum.in");

		System.out.println("Addding to database.........................");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.finByID(1));
		System.out.println(studentDAO.finByID(2));
		System.out.println(studentDAO.finByID(15));
	}

	private void getAllStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.finaAll());
	}

	private void getByLastName(StudentDAO studentDAO) {
		System.out.println(studentDAO.findByLastName("devi"));
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student getStudent = studentDAO.finByID(15);

		getStudent.setLastName("devi");

		studentDAO.update(getStudent);

		System.out.println(getStudent);
	}
}
