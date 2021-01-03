package com.training.educationsystem.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student_table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "middle_name", nullable = false)
	private String middleName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email_id", nullable = false)
	private String emailId;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "contact_number", nullable = false)
	private String contactNumber;

	@Column(name = "password", nullable = false)
	private String password;

	@Transient
	private String confirmPassword;

	@Column(name = "course_fk", nullable = true)
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	private List<Course> courses;

	@Column(name = "feedback_fk", nullable = true)
	@OneToMany(targetEntity = FeedBack.class, cascade = CascadeType.ALL)
	private List<FeedBack> feedback;

	public Student() {
		super();
	}

	public Student(int studentId, String firstName, String middleName, String lastName, String emailId, String userName,
			String contactNumber, String password, String confirmPassword, List<Course> courses,
			List<FeedBack> feedback) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.courses = courses;
		this.feedback = feedback;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<FeedBack> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<FeedBack> feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", userName=" + userName + ", contactNumber="
				+ contactNumber + ", password=" + password + ", confirmPassword=" + confirmPassword + ", courses="
				+ courses + ", feedback=" + feedback + "]";
	}

}
