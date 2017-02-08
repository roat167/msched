package edu.mum.swe.msched.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import edu.mum.swe.msched.enumeration.GENDER;
import edu.mum.swe.msched.enumeration.PREFERED_BLOCK;

/**
 * @author Dora
 *
 */
@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long facultyId;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.ORDINAL)
	private GENDER gender;
	private String snn;
	private Date startWorkDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "FACULTY_COURSE", joinColumns = {
			@JoinColumn(name = "FACULTY_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "COURSE_ID",nullable = false, updatable = false) })
	private List<Course> courses;
	@ElementCollection
	@CollectionTable(name = "prefered_blocks")
	private Set<PREFERED_BLOCK> preferedBlocks = new HashSet<PREFERED_BLOCK>(); // may change type later
	@OneToMany(mappedBy="faculty")
	private List<Section> sections = new ArrayList<Section>();

	public Long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public String getSnn() {
		return snn;
	}

	public void setSnn(String snn) {
		this.snn = snn;
	}	

	public Date getStartWorkDate() {
		return startWorkDate;
	}

	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Set<PREFERED_BLOCK> getPreferedBlocks() {
		return preferedBlocks;
	}

	public void setPreferedBlocks(Set<PREFERED_BLOCK> preferedBlocks) {
		this.preferedBlocks = preferedBlocks;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	@Transient
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", snn=" + snn + ", startWorkDate=" + startWorkDate + ", user=" + user + ", courses="
				+ courses + ", preferedBlocks=" + preferedBlocks + ", sections=" + sections + "]";
	}
	
}
