package com.attardco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "view_items")
public class ItemsView {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SYSREF", updatable = false, nullable = false)
	private Long SYSREF;
	private String CODE;
	private String DESC1;
	public Long getSYSREF() {
		return SYSREF;
	}
	public void setSYSREF(Long sYSREF) {
		SYSREF = sYSREF;
	}
	public String getCODE() {
		return CODE;
	}
	public void setCODE(String cODE) {
		CODE = cODE;
	}
	public String getDESC1() {
		return DESC1;
	}
	public void setDESC1(String dESC1) {
		DESC1 = dESC1;
	}
	
}
