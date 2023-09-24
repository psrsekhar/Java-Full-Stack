package org.sms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.sms.iservice.IStudentService;
import org.sms.model.Gender;
import org.sms.model.RegEx;
import org.sms.model.Student;

public class StudentService implements IStudentService {
	private List<Student> studentList = new ArrayList<Student>();

	public Boolean add(Student student) {
		Boolean isAdded = false;
		try {
			System.out.println("In StudentService add method");
			System.out.println("Generating ID for the student");
			student.setId(generateId());
			System.out.println(
					"Searching the student with id : " + student.getId() + " in the existing student list.....");
			if (this.studentList.stream().filter(std -> std.getId() == student.getId()).count() == 0) {
				System.out.println(
						"Student not found in the existing student list.\nTrying to validate the student details .....");
				if (validateInput(student)) {
					System.out.println(
							"*************************************************************\nTrying to add the student in to the student list.....");
					this.studentList.add(student);
					System.out.println(
							"Student added in to the student list.\n*************************************************************");
					isAdded = true;
				}
			} else {
				System.out.println("Student already exists in the student list.");
			}
		} catch (Exception ex) {
			System.err.println("\nException raised while adding the student with message : \n" + ex.getMessage());
		}
		return isAdded;
	}

	public Student getStudentById(Long id) {
		Student student = null;
		System.out.println("In StudentService getStudentById method");
		try {
			System.out.println("Searching the student with id : " + id + " in the existing student list.....");
			student = this.studentList.stream().filter(std -> std.getId().equals(id)).findAny().orElse(null);
		} catch (Exception ex) {
			System.err.println("Exception raised in getStudentById method with message: " + ex.getMessage());
		}
		return student;
	}

	public List<Student> getStudents() {
		System.out.println("In StudentService getStudents method");
		System.out.println("Fetching all the student details in the existing student list.....");
		return this.studentList;
	}

	public Boolean update(Student student) {
		Boolean isUpdated = false;
		try {
			System.out.println("In StudentService update method");
			System.out.println(
					"Searching the student with id : " + student.getId() + " in the existing student list.....");
			Student std = this.studentList.stream().filter(s -> s.getId() == student.getId()).findFirst().orElse(null);
			if (std != null) {
				System.out.println(
						"Student found in the existing student list.");
			} else {
				System.out.println("Student not found in the existing student list.");
			}
		} catch (Exception ex) {
			System.err.println("\nException raised while updating the student with message : \n" + ex.getMessage());
		}
		return isUpdated;
	}

	public Boolean delete(Long id) {
		Boolean isDeleted = false;
		try {
			System.out.println("In StudentService delete method");
			System.out.println(
					"Trying to  delete the student with id : " + id + " in the existing student list.....");
			if (this.studentList.removeIf(std -> std.getId().equals(id))) {				
				System.out.println(
						"Student deleted from the existing student list.");
				isDeleted = true;
			} else {
				System.out.println("Student not deleted in the existing student list.");
			}
		} catch (Exception ex) {
			System.err.println("\nException raised while deleting the student with message : \n" + ex.getMessage());
		}		
		return isDeleted;
	}
	
	private Long generateId() {
		return new Date().getTime();
	}

	private Boolean validateInput(Student student) {
		Boolean isValid = false;
		System.out.println("Validating the student details from the input.....\nValidating name(" + student.getName()
				+ ") of the student.....");
		isValid = validate(student.getName(), RegEx.NAME);
		if (isValid) {
			System.out.println("Name of the student is Valid.");
		} else {
			System.out.println("Name is invalid.");
			return isValid;
		}

		System.out.println("Validating gender(" + student.getGender() + ") of the student.....");
		isValid = Stream.of(Gender.values()).anyMatch(g -> g.name().equals(student.getGender().name()));
		if (isValid) {
			System.out.println("Gender of the student is valid.");
		} else {
			System.out.println("Gender is invalid.");
			return isValid;
		}

		System.out.println("Validating email(" + student.getEmail() + ") of the student.....");
		isValid = validate(student.getEmail().toString(), RegEx.EMAIL);
		if (isValid) {
			System.out.println("Email of the student is valid.");
		} else {
			System.out.println("Email is invalid.");
			return isValid;
		}

		System.out.println("Validating phone number(" + student.getPhno() + ") of the student.....");
		isValid = validate(student.getPhno().toString(), RegEx.PHNO);
		if (isValid) {
			System.out.println("Phone number of the student is valid.");
		} else {
			System.out.println("Phone number is invalid.");
			return isValid;
		}

		System.out.println("Validating address(" + student.getAddress() + ") of the student.....");
		isValid = validate(student.getAddress().toString(), RegEx.ADDRESS);
		if (isValid) {
			System.out.println("Address of the student is valid.");
		} else {
			System.out.println("Address is invalid.");
			return isValid;
		}
		return isValid;
	}

	private Boolean validate(String input, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}