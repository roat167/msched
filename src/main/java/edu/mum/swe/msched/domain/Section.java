package edu.mum.swe.msched.domain;

import javax.persistence.Column;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "block_id") // , insertable = false, updatable = false
	private Block block;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id", nullable = true)
	private Faculty faculty;
	private int minCapacity;
	private int maxCapacity;
	@Column(name = "total_student", nullable = false, columnDefinition = "int default 0")
	private int totalStudent;

	/** Getter and Starter **/
	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

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

	public int getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	}

	/** End of Getter and Starter **/


	@Override
	public boolean equals(Object obj) {
		if (null == obj || null == this.getSectionId())
			return false;
		return (this.getSectionId().equals(((Section) obj).getSectionId()));
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + (this.getSectionId() == null ? 0 : this.getSectionId().hashCode());
		return result;
	}
}
