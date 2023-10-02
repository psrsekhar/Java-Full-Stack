package edu.training.sms.repository;

import org.springframework.data.repository.CrudRepository;

import edu.training.sms.model.Student;

public interface IStudentRepository extends CrudRepository<Student, Long>{

}
