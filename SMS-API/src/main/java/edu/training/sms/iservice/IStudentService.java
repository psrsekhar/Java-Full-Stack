package edu.training.sms.iservice;

import java.util.List;

import edu.training.sms.model.Student;

public interface IStudentService {
	List<Student> getAllStudents();
	Student getStudentById(Long id);
	void saveOrUpdate(Student student);
	void delete(Long id);
}
