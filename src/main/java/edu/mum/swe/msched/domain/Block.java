package edu.mum.swe.msched.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blockId;
	private String name;
	private Date startDate;
	private Date endDate;
	@ManyToOne
	private Entry entry;
	@ElementCollection
	@CollectionTable(name = "target_electives")
	private Set<String> targetElectives = new HashSet<String>(); // might have to change type
	@OneToMany(mappedBy="block")
	private Set<Section> sections = new HashSet<Section>();
	
	public Long getBlockId() {
		return blockId;
	}

	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}

	public String getName() {
		return name;
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
