package edu.mum.swe.msched.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sectionId;
	//@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "block_id")
//	private Block block;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
	private Course course;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
	private Faculty faculty;
	private int minCapacity;
	private int maxCapacity;

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

//	public Block getBlock() {
//		return block;
//	}
//
//	public void setBlock(Block block) {
//		this.block = block;
//	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getMinCapacity() {
		return minCapacity;
	}

	public void setMinCapacity(int minCapacity) {
		this.minCapacity = minCapacity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

}
