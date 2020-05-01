package com.yurii.marviq_demoapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * The persistent class for the production database table.
 * 
 */
@Entity
@NamedQuery(name="Production.findAll", query="SELECT p FROM Production p")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime_from")
	private LocalDateTime datetimeFrom;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datetime_to")
	private LocalDateTime datetimeTo;

	@Column(name="machine_name")
	private String machineName;

	
	@Column(name="variable_name")
	private String variableName;
	
	private int value;

	public Production() {
	}

	
	public Production(LocalDateTime datetimeFrom, LocalDateTime datetimeTo, String machineName,String variableName, int value) {
		this.datetimeFrom = datetimeFrom;
		this.datetimeTo = datetimeTo;
		this.machineName = machineName;
		this.variableName = variableName;
		this.value = value;
	}


	@Override
	public String toString() {
		return "Production [datetimeFrom=" + datetimeFrom + ", datetimeTo=" + datetimeTo + ", machineName="
				+ machineName + ", value=" + value + "]";
	}


	public Production(int id, LocalDateTime datetimeFrom, LocalDateTime datetimeTo, String machineName, int value,
			String variableName) {
		this.id = id;
		this.datetimeFrom = datetimeFrom;
		this.datetimeTo = datetimeTo;
		this.machineName = machineName;
		this.value = value;
		this.variableName = variableName;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatetimeFrom() {
		return this.datetimeFrom;
	}

	public void setDatetimeFrom(LocalDateTime datetimeFrom) {
		this.datetimeFrom = datetimeFrom;
	}

	public LocalDateTime getDatetimeTo() {
		return this.datetimeTo;
	}

	public void setDatetimeTo(LocalDateTime datetimeTo) {
		this.datetimeTo = datetimeTo;
	}

	public String getMachineName() {
		return this.machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

}