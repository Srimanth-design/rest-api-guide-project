package com.examapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Exam {
	@Id
	@GeneratedValue(generator = "exam_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "exam_seq", sequenceName = "exam_sequence", initialValue = 100, allocationSize = 1)
	@Column(name = "examid")
	private Integer examId;
	@Column(name = "examname")
	private String examName;
	@Column(name = "timelimit")
	private String timeLimit;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examid")
	private Set<Question> questionList;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "examList")
	@JsonIgnore
	private Set<ExamCenter> centerList;

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 * @param examName
	 * @param timeLimit
	 * @param questionList
	 */

	public Exam(String examName, String timeLimit, Set<Question> questionList) {
		super();
		this.examName = examName;
		this.timeLimit = timeLimit;
		this.questionList = questionList;

	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Set<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", timeLimit=" + timeLimit + ", questionList="
				+ questionList + "]";
	}

}
