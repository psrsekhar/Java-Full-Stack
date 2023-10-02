package edu.training.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.training.sms.iservice.IStudentService;
import edu.training.sms.model.Student;
import edu.training.sms.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService {
	@Autowired
	IStudentRepository studentRepository;

	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		studentRepository.findAll().forEach(std -> studentList.add(std));
		return studentList;
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
}
