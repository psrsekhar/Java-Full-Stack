package org.sms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.sms.model.Gender;
import org.sms.model.Student;
import org.sms.service.StudentService;

public class SMS {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		Integer choice = 0;
		try {
			while (true) {
				menu();
				System.out.print("Enter your selection : ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					studentService.add(readInput());
					break;
				case 2:
					System.out.print("Enter ID of the student : ");
					Student student = studentService.getStudentById(scanner.nextLong());
					if (student != null) {
						System.out.println(
								"Student with id : " + student.getId() + " found in the existing student list.");
						System.out.print(
								"\n****************************************\n\tStudent Details\n****************************************");
						writeStudent(student);
						System.out.println("\n****************************************");
						System.out.println("End of student details......");
					} else {
						System.out.println("Student not found in the existing student list.");
					}
					break;
				case 3:
					List<Student> studentList = studentService.getStudents();
					if (studentList != null && studentList.size() > 0) {
						System.out.print(
								"\n****************************************\n\tStudent Details\n****************************************");
						for (Student std : studentList) {
							writeStudent(std);
							System.out.println("\n----------------------------------------");
						}
						System.out.println("\n\tEnd of student details......\n****************************************");
					} else {
						System.out.println(studentList.size() + " students found in the existing student list.");
					}
					break;
				case 4:
					break;
				case 5:
					System.out.print("Enter ID of the student : ");
					studentService.delete(scanner.nextLong());
					break;
				case 9:
					System.out.println("Terminating the program.");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice selected. Select a valid choice from menu.");
					break;
				}
			}
		} catch (Exception ex) {
			System.err.println("\nException raised in main method with message: " + ex.getMessage());
		} finally {
			System.out.println("Closing the scanner input stream.");
			scanner.close();
		}
	}

	private static void menu() {
		System.out.println("/n/n/tMENU");
		System.out.println("1: Add Student");
		System.out.println("2: Search Student");
		System.out.println("3: Display Students");
		System.out.println("4: Update Student");
		System.out.println("5: Delete Student");
		System.out.println("9: Exit program");
	}

	private static Student readInput() {
		Student student = new Student();

		System.out.print("enter name of the student : ");
		while (!scanner.hasNext("[A-Za-z]*")) {
			System.out.print("\nplease enter a valid name of the student: ");
			scanner.next();
		}
		student.setName(scanner.next());

		System.out.print("\nenter gender (1-Male, 2-Female, 3-Others) of the student : ");
		Integer gender;
		while (scanner.hasNextInt()) {
			gender = scanner.nextInt();
			if (gender == 1 || gender == 2 || gender == 3) {
				student.setGender(Gender.values()[gender - 1]);
				break;
			} else {
				System.out.print("\nplease enter a valid gender of the student: ");
			}
		}

		System.out.print("\nenter email of the student : ");
		while (!scanner.hasNext()) {
			System.out.print("\nplease enter a valid email of the student: ");
			scanner.next();
		}
		student.setEmail(scanner.next());

		System.out.print("\nenter phone number of the student : ");
		while (!scanner.hasNext("[0-9]*")) {
			System.out.print("\nplease enter a valid phone number of the student: ");
			scanner.next();
		}
		student.setPhno(scanner.next());

		try {
			System.out.print("\nenter date of birth of the student : ");
			while (!scanner.hasNext()) {
				System.out.print("\nplease enter a valid birth date of the student: ");
				scanner.next();
			}
			student.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next()));
		} catch (ParseException ex) {
			System.err.println("Invalid date.\nException with message : " + ex.getStackTrace());
		}

		System.out.print("\nenter address of the student : ");
		while (!scanner.hasNext("[A-Za-z]*")) {
			System.out.print("\nplease enter a valid address of the student: ");
			scanner.next();
		}
		student.setAddress(scanner.next());
		return student;
	}

	private static void writeStudent(Student student) {
		System.out.print("\nID : " + student.getId() + "\nName : " + student.getName() + "\nGender : "
				+ student.getGender() + "\nEmail : " + student.getEmail() + "\nPhone Number : " + student.getPhno()
				+ "\nAddress : " + student.getAddress());
	}
}