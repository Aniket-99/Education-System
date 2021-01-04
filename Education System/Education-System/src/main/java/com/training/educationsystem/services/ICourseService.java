package com.training.educationsystem.services;

import java.util.List;

import com.training.educationsystem.entities.Course;
import com.training.educationsystem.entities.Student;
import com.training.educationsystem.entities.Test;
import com.training.educationsystem.entities.Trainer;
import com.training.educationsystem.exceptions.AlreadyExistsException;
import com.training.educationsystem.exceptions.ListEmptyException;
import com.training.educationsystem.exceptions.NotFoundException;
import com.training.educationsystem.exceptions.TestNotFoundException;

public interface ICourseService {

	
	public Course addCourse(Course course);
	public void deleteCourse(int id) throws NotFoundException ;
	public Course viewCourse(int id)throws NotFoundException;
	public List<Course> viewAllCourses() throws ListEmptyException;
	public Course updateCourseForTrainers(int cid,String tname) throws NotFoundException,AlreadyExistsException;
	public Course updateCourseForStudents(int cid,String sname) throws NotFoundException,AlreadyExistsException;
	public Course updateCourseForPayment(int cid,int tid) throws NotFoundException;
	public Course updateCourseForTest(int cid,int tid) throws NotFoundException;
	public Course updateCourseForProgress(int cid,int pid) throws NotFoundException;
	public List<Trainer> viewTrainers(int cid)throws ListEmptyException;
	public List<Student> viewStudents(int cid)throws ListEmptyException;
	public Test viewTest(int cid) throws TestNotFoundException;
}

