package com.training.educationsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.educationsystem.controller.CourseController;
import com.training.educationsystem.entities.Course;
import com.training.educationsystem.entities.Payment;
import com.training.educationsystem.entities.Progress;
import com.training.educationsystem.entities.Student;
import com.training.educationsystem.entities.Test;
import com.training.educationsystem.entities.Trainer;
import com.training.educationsystem.exceptions.AlreadyExistsException;
import com.training.educationsystem.exceptions.CourseNotFoundException;
import com.training.educationsystem.exceptions.InvalidCourseException;
import com.training.educationsystem.exceptions.ListEmptyException;
import com.training.educationsystem.exceptions.NotFoundException;
import com.training.educationsystem.exceptions.TestNotFoundException;
import com.training.educationsystem.repositories.CourseRepository;
import com.training.educationsystem.repositories.PaymentRepository;
import com.training.educationsystem.repositories.ProgressRepository;
import com.training.educationsystem.repositories.StudentRepository;
import com.training.educationsystem.repositories.TestRepository;
import com.training.educationsystem.repositories.TrainerRepository;

/**
 * This is Service class for Course module
 * 
 * @author Afeeda A.H
 *
 */
@Transactional
@Service
public class CourseService implements ICourseService {

	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	CourseRepository courseRepo;

	@Autowired
	TrainerRepository trainerRepo;

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	PaymentRepository paymentRepo;

	@Autowired
	TestRepository testRepo;

	@Autowired
	ProgressRepository progressRepo;

	/**
	 * This method adds the course in the System
	 * 
	 * @param cname
	 * @param hours
	 * @return Course object
	 * @throws InvalidCourseException
	 */
	@Override
	public Course addCourse(Course course) {
		logger.info("Add Course (Service) - START");
		courseRepo.save(course);
		logger.info("Course Added Successfully!");
		logger.info("Add Course (Service) - END");
		return course;
	}

	/**
	 * This method deletes individual courses from the System
	 * 
	 * @param courseId
	 * @return Nothing
	 * @throws NotFoundException 
	 */
	@Override
	public void deleteCourse(int courseId) throws NotFoundException {
		logger.info("Delete Course (Service) - START");
		if(courseRepo.existsById(courseId)){
		courseRepo.deleteById(courseId);
		logger.info("Course Deleted Successfully!");
		logger.info("Delete Course (Service) - END");}
		else
		{
			logger.error("Course cannot be deleted as this Course cannot be found");
			throw new NotFoundException("Course cannot be deleted as this Course cannot be found");
		}
	}

	/**
	 * This method displays individual courses
	 * 
	 * @param courseId
	 * @return Course 
	 * @throws NotFoundException
	 */
	@Override
	public Course viewCourse(int courseId) throws NotFoundException {
		logger.info("View Course (Service) -START!");
		Course course = courseRepo.findById(courseId).orElse(null);
		if (course != null) {
			logger.info("Displaying Course!");
			logger.info("View Course  (Service) -END!");
			return course;
		} else {
			logger.error("Course cannot be Found!");
			throw new NotFoundException("Course cannot be Found!");
		}

	}

	/**
	 * This method displays list of all courses
	 * 
	 * @return List of courses
	 * @throws ListEmptyException
	 */
	@Override
	public List<Course> viewAllCourses() throws ListEmptyException {
		logger.info("View All Courses (Service) -START!");
		List<Course> courseList = courseRepo.findAll();
		if (courseList.size() > 0) {
			logger.info("Displaying Courses!");
			logger.info("View All Courses  (Service) -END!");
			return courseList;
		} else {
			logger.error("No Courses to Display");
			throw new ListEmptyException("No Courses to Display");
		}
	}

	/**
	 * This method adds Trainers in the Course specified
	 * 
	 * @param courseId
	 * @param firstName
	 * @return Course 
	 * @throws NotFoundException
	 * @throws AlreadyExistsException
	 */
	@Override
	public Course updateCourseForTrainers(int courseId, String firstName)
			throws NotFoundException, AlreadyExistsException {
		logger.info("Updating Course for Trainers (Service) -START!");
		Course course = courseRepo.findById(courseId).orElse(null);
		if (course != null) {
			List<Trainer> trainerList = course.getTrainers();
			List<String> nameList = trainerList.stream().map(e -> e.getFirstName()).collect(Collectors.toList());
			if (nameList.contains(firstName)) {
				logger.warn("Trainer Already assigned in Course ");
				throw new AlreadyExistsException("Trainer Already assigned in Course ");
			} else {
				List<Trainer> tlist = new ArrayList<Trainer>();
				Trainer trainer = trainerRepo.findByFirstName(firstName);

				tlist.add(trainer);
				course.setTrainers(tlist);
				courseRepo.save(course);
				logger.info("Adding Trainer!");
				logger.info("Updating Course for Trainers (Service) -END!");
				return course;
			}
		} else {
			logger.error("Trainer cannot be added!");
			throw new NotFoundException("Trainer cannot be added!");
		}

	}

	/**
	 * This method adds students who have enrolled in the course
	 * 
	 * @param courseId
	 * @param userName
	 * @return Course object
	 * @throws NotFoundException
	 * @throws AlreadyExistsException
	 */
	@Override
	public Course updateCourseForStudents(int courseId, String userName)
			throws NotFoundException, AlreadyExistsException {
		logger.info("Updating Course for Students (Service) -START!");
		Course course = courseRepo.findById(courseId).orElse(null);
		if (course != null) {
			List<Student> studentList = course.getStudents();

			List<String> usernameList = studentList.stream().map(e -> e.getUserName()).collect(Collectors.toList());
			if (usernameList.contains(userName)) {
				logger.warn("Student Already Enrolled in Course ");
				throw new AlreadyExistsException("Student Already Enrolled in Course ");
			} else {
				List<Student> slist = new ArrayList<Student>();
				Student student = studentRepo.findByUserName(userName);

				slist.add(student);
				course.setStudents(slist);
				courseRepo.save(course);
				logger.info("Adding Student!");
				logger.info("Updating Course for Students (Service) -END!");
				return course;
			}
		} else {
			logger.error("Student cannot be added");
			throw new NotFoundException("Student cannot be added");
		}

	}

	/**
	 * This method adds payment in the course after enrollment
	 * 
	 * @param courseId
	 * @param transactionId
	 * @return Course 
	 * @throws NotFoundException
	 */

	@Override
	public Course updateCourseForPayment(int courseId, int transactionId) throws NotFoundException {
		logger.info("Updating Course  for Payment (Service) -START!");
		Payment payment = paymentRepo.getOne(transactionId);
		Course course = courseRepo.getOne(courseId);
		if (course != null) {
			course.setPayment(payment);
			courseRepo.save(course);
			logger.info("Adding Payment!");
			logger.info("Updating Course for Payment (Service) -END!");
			return course;
		} else {
			logger.error("Payment cannot be added");
			throw new NotFoundException("Payment cannot be added");
		}

	}
	/**
	 * This method displays available Trainers for individual courses
	 * 
	 * @param courseId
	 * @return List of Trainers
	 * @throws ListEmptyException
	 */
	@Override
	public List<Trainer> viewTrainers(int courseId) throws ListEmptyException {
		logger.info("View Trainers (Service) -START!");
		Course course = courseRepo.getOne(courseId);
		List<Trainer> trainerList = course.getTrainers();
		if (trainerList.size() > 0) {
			logger.info("Displaying Trainers!");
			logger.info("View Trainers (Service) -END!");
			return trainerList;
		} else {
			logger.error("No Trainers to show !");
			throw new ListEmptyException("No Trainers to show!");
		}

	}

	/**
	 * This method displays Students for individual courses
	 * 
	 * @param courseId
	 * @return List of Students
	 * @throws ListEmptyException
	 */

	@Override
	public List<Student> viewStudents(int courseId) throws ListEmptyException {
		logger.info("View Students (Service) -START!");
		Course course = courseRepo.getOne(courseId);
		List<Student> students = course.getStudents();
		if (students.size() > 0) {
			logger.info("Displaying Studnets!");
			logger.info("View Students (Service) -END!");
			return students;
		} else {
			logger.error("No students to show!");
			throw new ListEmptyException("No students to show!");
		}

	}

	/**
	 * This method adds Test for each course specified
	 * 
	 * @param courseId
	 * @param testId
	 * @return Course 
	 * @throws CourseNotFoundException
	 */
	@Override
	public Course updateCourseForTest(int courseId, int testId) throws NotFoundException {
		logger.info("Updating Course for  Test (Service) -START!");
		Test test = testRepo.getOne(testId);
		Course course = courseRepo.getOne(courseId);
		if (course != null) {
			course.setTest(test);
			courseRepo.save(course);
			logger.info("Adding Test!");
			logger.info("Updating Course for Test  (Service) -END!");
			return course;
		} else {
			logger.error("Test cannot be added");
			throw new NotFoundException("Test cannot be added");
		}

	}

	/**
	 * This method displays Test for each course
	 * 
	 * @param courseId
	 * @return Test 
	 * @throws TestNotFoundException
	 */
	@Override
	public Test viewTest(int courseId) throws TestNotFoundException {
		logger.info("View Test (Service) -START!");
		Course course = courseRepo.getOne(courseId);
		if (course != null) {
			logger.info("Displaying Test!");
			logger.info("View Test  (Service) -END!");
			return course.getTest();
		} else {
			logger.error("Test cannot be found!");
			throw new TestNotFoundException("Test cannot be found!");
		}

	}

	/**
	 * This method adds Progress for each Course specified
	 * @param courseId
	 * @param progressId
	 * @return Course
	 * @throws CourseNotFoundException
	 */
	@Override
	public Course updateCourseForProgress(int courseId, int progressId) throws NotFoundException {
		logger.info("Updating Course for Progress (Service) -START!");
		Progress progress = progressRepo.getOne(progressId);
		Course course = courseRepo.getOne(courseId);
		if (course != null) {
			course.setProgress(progress);
			courseRepo.save(course);
			logger.info("Adding Progress!");
			logger.info("Updating Course for Progress (Service) -END!");
			return course;
		} else {
			logger.error("Progress cannot be added");
			throw new NotFoundException("Progress cannot be added");
		}
	}

}
