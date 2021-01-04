package com.training.educationsystem.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.training.educationsystem.entities.Course;
import com.training.educationsystem.entities.Payment;
import com.training.educationsystem.entities.Progress;
import com.training.educationsystem.exceptions.ListEmptyException;
import com.training.educationsystem.exceptions.NotFoundException;
import com.training.educationsystem.repositories.CourseRepository;
import com.training.educationsystem.repositories.PaymentRepository;
import com.training.educationsystem.repositories.ProgressRepository;
import com.training.educationsystem.repositories.StudentRepository;
import com.training.educationsystem.repositories.TrainerRepository;
import com.training.educationsystem.services.CourseService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CourseServiceTest {
	
	@InjectMocks
	private CourseService CourseService;
	
	@MockBean
	private CourseRepository CourseRepo;
	
	@MockBean 
	private StudentRepository studentRepo;
	
	@MockBean
	private TrainerRepository trainerRepo;
	
	@MockBean
	private PaymentRepository paymentRepo;
	
	@MockBean
	private ProgressRepository progressRepo;
	
	@Test
	public void testAddCourse()
	{
		Course course=new Course();
		
		course.setCourseId(0);
		course.setCourseName("JavaEE");
		course.setHours(12);
		
		Mockito.when(CourseRepo.save(course)).thenReturn(course);
		assertThat(CourseService.addCourse(course)).isEqualTo(course);
	}
	
	@Test
	public void testViewAllCourses() throws  ListEmptyException {
		Course c1=new Course();
		c1.setCourseName("C");
		c1.setHours(5);
		
		Course c2=new Course();
		c2.setCourseName("SQL");
		c2.setHours(6);
		
		List<Course> courses=new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		
		Mockito.when(CourseRepo.findAll()).thenReturn(courses);
		assertThat(CourseService.viewAllCourses()).isEqualTo(courses);
		}

	@Test
	public void testViewCourse() throws NotFoundException {
		Course course=new Course();
		course.setCourseId(1);
		course.setCourseName("Python");
		course.setHours(4);
		
		Mockito.when(CourseRepo.getOne(1)).thenReturn(course);
		assertThat(CourseRepo.getOne(1)).isEqualTo(course);
		
	}
	
	@Test
	public void testDeleteCourse() {
		Course course=new Course();
		course.setCourseId(1);
		course.setCourseName("DBMS");
		course.setHours(5);
		
		Mockito.when(CourseRepo.getOne(1)).thenReturn(course);
		Mockito.when(CourseRepo.existsById(course.getCourseId())).thenReturn(false);
		assertFalse(CourseRepo.existsById(course.getCourseId()));
	}
	
	
	@Test
	public void testUpdateCourseForPayment() throws  NotFoundException {
        Course course=new Course();
		
        course.setCourseId(1);
		course.setCourseName("DBMS");
		course.setHours(5);
		
		Payment payment=new Payment();
		payment.setTransactionId(2);
		payment.setBankName("HDFC");
		payment.setCardNumber(123456);
		payment.setAmount(12000);
		
		course.setPayment(payment);
		
		Mockito.when(CourseRepo.getOne(1)).thenReturn(course);
		assertThat(CourseService.updateCourseForPayment(course.getCourseId(), payment.getTransactionId())).isEqualTo(course);
		
	}
	
	@Test
	public void testUpdateCourseForProgress() throws NotFoundException {
        Course course=new Course();
		
        course.setCourseId(1);
		course.setCourseName("DBMS");
		course.setHours(5);
		
		Progress progress=new Progress();
		progress.setProgressId(1);
		progress.setCompletedHours(3);
		
		course.setProgress(progress);
		
		Mockito.when(CourseRepo.getOne(1)).thenReturn(course);
		assertThat(CourseService.updateCourseForProgress(course.getCourseId(), progress.getProgressId())).isEqualTo(course);
		
	}
	
	
}
