package edu.training.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.training.sms.model.Student;
import edu.training.sms.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/add")
	private Long saveBook(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student.getId();
	}

	@PutMapping("/update")
	private Student update(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student;
	}

	@GetMapping("/students")
	private List<Student> getAllBooks() {
		return studentService.getAllStudents();
	}

	@GetMapping("/student/{id}")
	private Student getBooks(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping("/student/{id}")
	private void deleteBook(@PathVariable("id") Long id) {
		studentService.delete(id);
	}
}
