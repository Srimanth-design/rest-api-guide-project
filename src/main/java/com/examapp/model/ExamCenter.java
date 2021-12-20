package com.examapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "examcenter")
public class ExamCenter {

	@Id
	@GeneratedValue(generator = "center_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "center_seq", sequenceName = "center_seq", initialValue = 200, allocationSize = 1)
	@Column(name = "centerid")
	private Integer centerId;
	@Column(name = "centername", length = 20)
	private String centerName;
	@Column(length = 20)
	private String location;

	@ManyToMany(fetch =FetchType.EAGER)
	@JoinTable(name = "center_exam", joinColumns = @JoinColumn(name = "centerid"), inverseJoinColumns = @JoinColumn(name = "examid"))

	private Set<Exam> examList;


	public ExamCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 * @param centerName
	 * @param location
	 * @param examList
	 */

	public ExamCenter(String centerName, String location, Set<Exam> examList) {
		super();
		this.centerName = centerName;
		this.location = location;
		this.examList = examList;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Exam> getExamList() {
		return examList;
	}

	public void setExamList(Set<Exam> examList) {
		this.examList = examList;
	}

	@Override
	public String toString() {
		return "ExamCenter [centerId=" + centerId + ", centerName=" + centerName + ", location=" + location
				+ ", examList=" + examList + "]";
	}

	
	

}
