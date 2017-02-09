package edu.mum.swe.msched.domain;

import javax.persistence.*;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long scheduleId;

	@OneToOne
	//@JoinColumn(name = "entry_id", insertable=false, updatable=false)
	private Entry entry;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}
}
