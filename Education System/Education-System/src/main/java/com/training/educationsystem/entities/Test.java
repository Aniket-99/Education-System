package com.training.educationsystem.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_table")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "test_id")
	private int testId;

	@Column(name = "test_name")
	private String testName;

	@Column(name = "question_fk", nullable = false)
	@OneToMany(targetEntity = Question.class, cascade = CascadeType.ALL)
	private List<Question> question;

	@Column(name = "score")
	private float score;

	@Column(name = "number_of_attempts")
	private int numberOfAttempts;

	public Test() {
		super();
	}

	public Test(int testId, String testName, List<Question> question, float score, int numberOfAttempts) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.question = question;
		this.score = score;
		this.numberOfAttempts = numberOfAttempts;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", question=" + question + ", score=" + score
				+ ", numberOfAttempts=" + numberOfAttempts + "]";
	}

}