package com.training.educationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.educationsystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	public Student findByFirstName(String name);
	
	public Student findByUserName(String username);

	//public Student findByEmailId(String emailId);

	//public List<Student> findByIsValidateFalse();
	
	//public Student findByUserNameAndPassword(String username, String password);
	
	//public List<Student> findByIsValidateTrue();
}
