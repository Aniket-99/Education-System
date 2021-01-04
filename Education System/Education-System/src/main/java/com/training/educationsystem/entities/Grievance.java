package com.training.educationsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * creating Grievance entity here
 */
@Entity
@Table(name = "Grievance")
public class Grievance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "student_id")
	private int studentId;
	@Column(name = "sname")
	private String sname;
	@Column(name = "grievance")
	private String grievance;
	@Column(name = "reply")
	private String reply;

	public int getId() {
		return id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudent(int studentId) {
		this.studentId = studentId;
	}

	public String getGrievance() {
		return grievance;
	}

	public void setGrievance(String grievance) {
		this.grievance = grievance;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "Grievance [id=" + id + ", studentId=" + studentId + ", sname=" + sname + ", grievance=" + grievance
				+ ", reply=" + reply + "]";
	}

}