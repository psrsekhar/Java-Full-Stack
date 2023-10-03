package edu.training.sms.iservice;

import java.util.List;

import edu.training.sms.model.Student;

public interface IStudentService {
	Boolean addOrUpdate(Student student);

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	Boolean delete(Long id);
}
