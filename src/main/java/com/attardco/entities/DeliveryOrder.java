package com.attardco.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DeliveryOrder")
public class DeliveryOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orders_seq")
	@SequenceGenerator(
	    name="orders_seq",
	    sequenceName="orders_sequence",
	    initialValue=78000000
	)
	@Column(name="DelOrdRef")
	private long DelOrdRef;	
	@JsonIgnore
	@OneToMany(targetEntity=DeliveryNote.class, mappedBy="DelOrdRef",
			cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	private List<DeliveryNote> deliveryNoteHeaderRef = new ArrayList<>();
	@Column(name="DelOrdDate")
	private LocalDate DelOrdDate;
	@Column(name="CustRef")
	private String CustRef;
	@Column(name="CustName")
	private String CustName;
	@Column(name="CustAddr1")
	private String CustAddr1;
	@Column(name="CustAddr2")
	private String CustAddr2;
	@Column(name="CustAddr3")
	private String CustAddr3;
	@Column(name="CustAddr4")
	private String CustAddr4;
	@Column(name="CustTown")
	private String CustTown;
	@Column(name="DefSendMessage")
	private String DefSendMessage;
	@Column(name="DeliveryInstructions")
	private String DeliveryInstructions;
	@Column(name="InvoiceRef")
	private int InvoiceRef;
	@Column(name="Status")
	private String Status;

	public long getDelOrdRef() {
		return DelOrdRef;
	}
	public void setDelOrdRef(Long delOrdRef) {
		DelOrdRef = delOrdRef;
	}
	
	public List<DeliveryNote> getDeliveryNoteHeaderRef() {
		return deliveryNoteHeaderRef;
	}
	public void setDeliveryNoteHeaderRef(List<DeliveryNote> deliveryNoteHeaderRef) {
		this.deliveryNoteHeaderRef = deliveryNoteHeaderRef;
	}
	
	public LocalDate getDelOrdDate() {
		return DelOrdDate;
	}
	public void setDelOrdDate(LocalDate delOrdDate) {
		DelOrdDate = delOrdDate;
	}
	public String getCustRef() {
		return CustRef;
	}
	public void setCustRef(String custRef) {
		CustRef = custRef;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getCustAddr1() {
		return CustAddr1;
	}
	public void setCustAddr1(String custAddr1) {
		CustAddr1 = custAddr1;
	}
	public String getCustAddr2() {
		return CustAddr2;
	}
	public void setCustAddr2(String custAddr2) {
		CustAddr2 = custAddr2;
	}
	public String getCustAddr3() {
		return CustAddr3;
	}
	public void setCustAddr3(String custAddr3) {
		CustAddr3 = custAddr3;
	}
	public String getCustAddr4() {
		return CustAddr4;
	}
	public void setCustAddr4(String custAddr4) {
		CustAddr4 = custAddr4;
	}
	public String getCustTown() {
		return CustTown;
	}
	public void setCustTown(String custTown) {
		CustTown = custTown;
	}
	public String getDefSendMessage() {
		return DefSendMessage;
	}
	public void setDefSendMessage(String defSendMessage) {
		DefSendMessage = defSendMessage;
	}
	public String getDeliveryInstructions() {
		return DeliveryInstructions;
	}
	public void setDeliveryInstructions(String deliveryInstructions) {
		DeliveryInstructions = deliveryInstructions;
	}
	public int getInvoiceRef() {
		return InvoiceRef;
	}
	public void setInvoiceRef(int invoiceRef) {
		InvoiceRef = invoiceRef;
	}	

	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public DeliveryOrder() {

	}

	
}