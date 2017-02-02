package edu.mum.swe.msched.domain;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long entryId;
	private String name;
	@OneToMany(mappedBy="entry")
	private List<Block> blocks;
	private int mppStudentNum;
	private int fppStudentNum;
	private double percentOfCPT;
	private double percentOfOPT;
	private int localStudentNum;
	@Temporal(TemporalType.TIMESTAMP)	
	private Date entryDate;
	//@Transient
	private String displayEntryDate;

	public String getDisplayEntryDate() {
		return displayEntryDate;
	}

	public void setDisplayEntryDate(String displayEntryDate) {
		this.displayEntryDate = displayEntryDate;
	}

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public int getMppStudentNum() {
		return mppStudentNum;
	}

	public void setMppStudentNum(int mppStudentNum) {
		this.mppStudentNum = mppStudentNum;
	}

	public int getFppStudentNum() {
		return fppStudentNum;
	}

	public void setFppStudentNum(int fppStudentNum) {
		this.fppStudentNum = fppStudentNum;
	}

	public double getPercentOfCPT() {
		return percentOfCPT;
	}

	public void setPercentOfCPT(double percentOfCPT) {
		this.percentOfCPT = percentOfCPT;
	}

	public double getPercentOfOPT() {
		return percentOfOPT;
	}

	public void setPercentOfOPT(double percentOfOPT) {
		this.percentOfOPT = percentOfOPT;
	}

	public int getLocalStudentNum() {
		return localStudentNum;
	}

	public void setLocalStudentNum(int localStudentNum) {
		this.localStudentNum = localStudentNum;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
//	public String getDisplayEntryDate() {
//		return CustomDateFormatter.displayDateFormat(entryDate);
//	}
//
//	public void setDisplayEntryDate(String displayEntryDate) {
//		this.displayEntryDate = displayEntryDate;
//	}


}
