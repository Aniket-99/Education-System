package com.training.educationsystem.entities;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="Feedback")
	public class Feedback {
		
/**
* creating Feedback entity
*/
		
			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
		    int id;
				
			public void setId(int id) {
				this.id = id;
			}

			@Column(name="sname")
		    String sname;
			@Column(name="feedback")
		    String feedback;		
			@Column(name="reply")
			String reply;
			
			public Feedback() {
				
			}
			
			public Feedback(int id, String sname, String feedback, String reply) {
				super();
				this.id = id;
				this.sname = sname;
				this.feedback = feedback;
				this.reply = reply;
			}

			public int getId() {
					return id;
			}
			
			public String getSname() {
					return sname;
			}
			
			public void setSname(String sname) {
				this.sname = sname;
			}
			
			public String getFeedback() {
					return feedback;
			}	
			public void setFeedback(String feedback) {
					this.feedback = feedback;
			}
			
			public String getReply() {
					return reply;
			}
			public void setReply(String reply) {
					this.reply = reply;
			}

			@Override
			public String toString() {
					return "Feedback [id=" + id + ",  sname=" + sname + ", feedback="
							+ feedback + ", reply=" + reply + "]";
			}
			
				
				
		}


	//reply=" + reply + ", 