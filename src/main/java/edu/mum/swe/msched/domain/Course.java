package edu.mum.swe.msched.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String courseName;
	@NotEmpty
	private String courseCode;
	@NotEmpty
	private String description;
	@OneToOne
	private Course preReqiusite;
	@ElementCollection
	@CollectionTable(name = "target_blocks")
	private Set<String> targetBlocks = new HashSet<String>();

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Course getPreReqiusite() {
		return preReqiusite;
	}

	public void setPreReqiusite(Course preReqiusite) {
		this.preReqiusite = preReqiusite;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getgetCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getTargetBlocks() {
		return targetBlocks;
	}

	public void setTargetBlocks(Set<String> targetBlocks) {
		this.targetBlocks = targetBlocks;
	}

}
