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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String courseName;
	@NotNull
	@Range(min=300,max=599)
	private int courseCode;
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

	public int getCourseCode() {
		return courseCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public void setCourseCode(int courseCode) {
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

	public boolean mEquals(Course course) {
		if (course  == null) {
			return false;
		}
		if ((this.getId() == null || this.getId() != course.getId()) && 
				(this.getCourseName().equals(course.getCourseName()) || this.getCourseCode() == course.getCourseCode())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseCode=" + courseCode + ", description="
				+ description + ", preReqiusite=" + preReqiusite + ", targetBlocks=" + targetBlocks + "]";
	}
	
}
