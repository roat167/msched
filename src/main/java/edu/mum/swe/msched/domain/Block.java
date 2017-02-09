package edu.mum.swe.msched.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.swe.msched.helper.DateTimeHelper;


@Entity
public class Block {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String name;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date endDate;
	@ManyToOne
	@JoinColumn(name = "entry_id")
	private Entry entry;
	@ElementCollection
	@CollectionTable(name = "target_electives")
	private Set<String> targetElectives = new HashSet<String>(); // might have
																	// to change
																	// type
	@OneToMany(mappedBy = "block", cascade = CascadeType.ALL)
	private Set<Section> sections = new HashSet<Section>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		// + " " + DateTimeHelper.getDisplayDateBetween(startDate, endDate)
		return name + " " + DateTimeHelper.getDisplayDateBetween(startDate, endDate);
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public Set<String> getTargetElectives() {
		return targetElectives;
	}

	public void setTargetElectives(Set<String> targetElectives) {
		this.targetElectives = targetElectives;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

}
