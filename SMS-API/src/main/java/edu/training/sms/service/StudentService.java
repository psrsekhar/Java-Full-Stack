package edu.training.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.training.sms.iservice.IStudentRepository;
import edu.training.sms.iservice.IStudentService;
import edu.training.sms.model.Student;

@Service
public class StudentService implements IStudentService {
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Boolean addOrUpdate(Student student) {
		Boolean isSaved = false;
		try {
			studentRepository.save(student);
			isSaved = true;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return isSaved;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		try {
			studentRepository.findAll().forEach(std -> studentList.add(std));
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return studentList;
	}

	@Override
	public Student getStudentById(Long id) {
		try {
			return studentRepository.findById(id).get();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		Boolean isDeleted = false;
		try {
			studentRepository.deleteById(id);
			isDeleted = true;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return isDeleted;
	}
}
