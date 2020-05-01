package com.yurii.marviq_demoapp.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the runtime database table.
 * 
 */
@Entity
@NamedQuery(name="Runtime.findAll", query="SELECT r FROM Runtime r")
public class Runtime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime datetime;

	private byte isrunning;

	@Column(name="machine_name")
	private String machineName;

	public Runtime() {
	}
	

	public Runtime(int id, LocalDateTime datetime, byte isrunning, String machineName) {
		this.id = id;
		this.datetime = datetime;
		this.isrunning = isrunning;
		this.machineName = machineName;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatetime() {
		return this.datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public byte getIsrunning() {
		return this.isrunning;
	}

	public void setIsrunning(byte isrunning) {
		this.isrunning = isrunning;
	}

	public String getMachineName() {
		return this.machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

}