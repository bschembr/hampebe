package com.attardco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "client_items")
public class ClientsView {
	@Id
	@Column(name = "ACCOUNT", updatable = false, nullable = false)
	private String ACCOUNT;
	private String NAME;
	private String ADDRESSLN1;
	private String ADDRESSLN2;
	private String ADDRESSLN3;
	private String ADDRESSLN4;
	public String getACCOUNT() {
		return ACCOUNT;
	}
	public void setACCOUNT(String aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESSLN1() {
		return ADDRESSLN1;
	}
	public void setADDRESSLN1(String aDDRESSLN1) {
		ADDRESSLN1 = aDDRESSLN1;
	}
	public String getADDRESSLN2() {
		return ADDRESSLN2;
	}
	public void setADDRESSLN2(String aDDRESSLN2) {
		ADDRESSLN2 = aDDRESSLN2;
	}
	public String getADDRESSLN3() {
		return ADDRESSLN3;
	}
	public void setADDRESSLN3(String aDDRESSLN3) {
		ADDRESSLN3 = aDDRESSLN3;
	}
	public String getADDRESSLN4() {
		return ADDRESSLN4;
	}
	public void setADDRESSLN4(String aDDRESSLN4) {
		ADDRESSLN4 = aDDRESSLN4;
	}
	public String getTOWN() {
		return TOWN;
	}
	public void setTOWN(String tOWN) {
		TOWN = tOWN;
	}
	private String TOWN;
}
