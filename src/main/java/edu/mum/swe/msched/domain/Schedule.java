package edu.mum.swe.msched.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long scheduleId;

}
