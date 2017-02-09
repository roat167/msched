package edu.mum.swe.msched.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.swe.msched.util.SectionDao;

@Entity
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long entryId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "entry")
	@OrderBy(value = "startDate")
	private List<Block> blocks = new ArrayList<Block>();
	@NotNull
	@Range(min = 1, max = 1000)
	private int mppStudentNum;
	@NotNull
	@Range(min = 1, max = 1000)
	private int fppStudentNum;
	private double percentOfCPT;
	private double percentOfOPT;
	private int localStudentNum;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date entryDate;
	@Transient
	private String displayEntryDate;

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
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

	public String getDisplayEntryDate() {
		return SectionDao.displayDateFormat(entryDate);
	}

	public void setDisplayEntryDate(String displayEntryDate) {
		this.displayEntryDate = displayEntryDate;
	}

}
