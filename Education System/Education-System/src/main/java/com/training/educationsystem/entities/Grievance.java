package com.training.educationsystem.entities;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="Grievance")
	public class Grievance {
		
/**
 * creating Grievance entity here
 */
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int id;
				
		@Column(name="student_id")
		int student_id;
		@Column(name="sname")
		String sname;
		@Column(name="grievance")
		String grievance;
		@Column(name="reply")
		String reply;			    
			    	
			public int getId() {
					return id;
				}
			
				public String getSname() {
					return sname;
				}
				public void setSname(String sname) {
					this.sname = sname;
				}
				
				public int getStudent_id() {
					return student_id;
				}
				public void setStudent_id(int student_id) {
					this.student_id = student_id;
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
					return "Grievance [id=" + id + ", student_id=" + student_id + ", sname=" + sname + ", grievance="
							+ grievance + ", reply=" + reply + "]";
				}
				
	}