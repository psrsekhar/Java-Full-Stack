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
	private Long add(@RequestBody Student student) {
		studentService.addOrUpdate(student);
		return student.getId();
	}
	
	@GetMapping("/students")
	private List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	private Student getStudentById(@PathVariable("id") Long id){
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/update")
	private Long update(@RequestBody Student student) {
		studentService.addOrUpdate(student);
		return student.getId();
	}
	
	@DeleteMapping("/delete/{id}")
	private Boolean delete(@PathVariable("id") Long id) {
		return studentService.delete(id);
	}
}
