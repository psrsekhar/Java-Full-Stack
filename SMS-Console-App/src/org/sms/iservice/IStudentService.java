package org.sms.iservice;

import java.util.List;

import org.sms.model.Student;

public interface IStudentService {
	Boolean add(Student student);
	Student getStudentById(Long id);
	List<Student> getStudents();
	Boolean delete(Long id);
}
