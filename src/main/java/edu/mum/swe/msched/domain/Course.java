package edu.mum.swe.msched.domain;

import java.util.List;

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
	private List<String> targetBlocks;

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

	public List<String> getTargetBlocks() {
		return targetBlocks;
	}

	public void setTargetBlocks(List<String> targetBlocks) {
		this.targetBlocks = targetBlocks;
	}

}
