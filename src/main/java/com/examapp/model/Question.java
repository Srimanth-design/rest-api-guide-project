package com.examapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Question {
	@Id
	@GeneratedValue(generator = "question_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "question_seq", sequenceName = "question_seq", initialValue = 1, allocationSize = 1)
	private Integer questionId;
	@Column(length = 100)
	private String question;
	@Column(length = 20)
	private String subject;
	@Column(length = 20)
	private String topic;
	@Column(name = "marksdedicated")
	private int marksDedicated;
	@Column(length = 20)
	private String university;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "answerid")
	private Answer answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param question
	 * @param subject
	 * @param topic
	 * @param marksDedicated
	 * @param university
	 * @param answer
	 */
	public Question(String question, String subject, String topic, int marksDedicated,
			String university, Answer answer) {
		super();
		this.question = question;
		this.subject = subject;
		this.topic = topic;
		this.marksDedicated = marksDedicated;
		this.university = university;
		this.answer = answer;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getMarksDedicated() {
		return marksDedicated;
	}

	public void setMarksDedicated(int marksDedicated) {
		this.marksDedicated = marksDedicated;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", subject=" + subject + ", topic="
				+ topic + ", marksDedicated=" + marksDedicated + ", university="
				+ university + ", answer=" + answer + "]";
	}

}
