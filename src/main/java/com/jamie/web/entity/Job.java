package com.jamie.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobNo;
	private Integer comMemId;
	private String jobName;
	private Integer jobStatus;

}
