package edu.mum.swe.msched.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long couresId;
	private String code;
	private String description;
	@ElementCollection
	@CollectionTable(name = "target_blocks")
	private Set<String> targetBlocks = new HashSet<String>();

	public Long getCouresId() {
		return couresId;
	}

	public void setCouresId(Long couresId) {
		this.couresId = couresId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
