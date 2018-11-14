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
@Table(name = "view_eyeselInv")
public class EyeSelInvoiceView {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SYSREF", updatable = false, nullable = false)
	private Long SYSREF;
	private String SalesOrder;
	private String ClientCode;
	private String ItemCode;
	private Long Qty;
	private String Display;
	private String InvNum;
	
	public Long getSYSREF() {
		return SYSREF;
	}
	public void setSYSREF(Long sYSREF) {
		SYSREF = sYSREF;
	}
	public String getSalesOrder() {
		return SalesOrder;
	}
	public void setSalesOrder(String salesOrder) {
		SalesOrder = salesOrder;
	}
	public String getClientCode() {
		return ClientCode;
	}
	public void setClientCode(String clientCode) {
		ClientCode = clientCode;
	}
	public String getItemCode() {
		return ItemCode;
	}
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public Long getQty() {
		return Qty;
	}
	public void setQty(Long qty) {
		Qty = qty;
	}
	public String getDisplay() {
		return Display;
	}
	public void setDisplay(String display) {
		Display = display;
	}
	public String getInvNum() {
		return InvNum;
	}
	public void setInvNum(String invNum) {
		InvNum = invNum;
	}

	
}
