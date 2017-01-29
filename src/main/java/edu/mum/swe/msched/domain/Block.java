package edu.mum.swe.msched.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blockId;
	private String name;
	private Date startDate;
	private Date endDate;
	@ElementCollection
	@CollectionTable(name = "target_electives")
	private List<String> targetElectives; // might have to change type

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

	public List<String> getTargetElectives() {
		return targetElectives;
	}

	public void setTargetElectives(List<String> targetElectives) {
		this.targetElectives = targetElectives;
	}
}
