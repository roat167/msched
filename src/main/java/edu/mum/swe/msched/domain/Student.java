package edu.mum.swe.msched.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import edu.mum.swe.msched.enumeration.GENDER;
import edu.mum.swe.msched.enumeration.STUDENT_TYPE;

/**
 * @author Dora
 *
 */
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@Enumerated(EnumType.ORDINAL)
	private GENDER gender;
	private String snn;
	@ManyToOne
	@JoinColumn(name="entry_id")
	private Entry entry;
	@Enumerated(EnumType.ORDINAL)
	private STUDENT_TYPE studentType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_SECTION", joinColumns = {
			@JoinColumn(name = "STUDENT_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "SECTION_ID",nullable = false, updatable = false) })
	private List<Section> sections = new ArrayList<Section>();

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public STUDENT_TYPE getStudentType() {
		return studentType;
	}

	public void setStudentType(STUDENT_TYPE studentType) {
		this.studentType = studentType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", snn=" + snn + ", entry=" + entry + ", studentType=" + studentType + ", account=" + account.toString()
				+ ", sections=" + sections + "]";
	}

	
}
