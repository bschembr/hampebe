package com.attardco.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DeliveryNote")
public class DeliveryNote {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private long DelNoteRef;	
	@ManyToOne
	@JoinColumn(name="delOrderRef_id")
//	@JsonIgnore
	private DeliveryOrder DelOrdRef;
	private LocalDate DelNoteDate;
	private String SenderName;
	private String SenderAddr1;
	private String SenderAddr2;
	private String SenderAddr3;
	private String SenderAddr4;
	private String SenderTown;
	private LocalDate DeliveryDate;
	private String DeliveryTime;
	private String SenderMessage;
	private String ReceiverName;
	private String ReceiverAddr1;
	private String ReceiverAddr2;
	private String ReceiverAddr3;
	private String ReceiverAddr4;
	private String ReceiverTown;
	private String ReceiverPhone;
	private String DeliveryInstructions;
	private String ItemCode;
	private String ItemDescription;
	private long qtyOrd;
	private String Status;

	public long getDelNoteRef() {
		return DelNoteRef;
	}
	public void setDelNoteRef(int delNoteRef) {
		DelNoteRef = delNoteRef;
	}

	public DeliveryOrder getDelOrdRef() {
		return DelOrdRef;
	}
	public void setDelOrdRef(DeliveryOrder delOrdRef) {
		DelOrdRef = delOrdRef;
	}
	
	public LocalDate getDelNoteDate() {
		return DelNoteDate;
	}
	public void setDelNoteDate(LocalDate delNoteDate) {
		DelNoteDate = delNoteDate;
	}
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getSenderAddr1() {
		return SenderAddr1;
	}
	public void setSenderAddr1(String senderAddr1) {
		SenderAddr1 = senderAddr1;
	}
	public String getSenderAddr2() {
		return SenderAddr2;
	}
	public void setSenderAddr2(String senderAddr2) {
		SenderAddr2 = senderAddr2;
	}
	public String getSenderAddr3() {
		return SenderAddr3;
	}
	public void setSenderAddr3(String senderAddr3) {
		SenderAddr3 = senderAddr3;
	}
	public String getSenderAddr4() {
		return SenderAddr4;
	}
	public void setSenderAddr4(String senderAddr4) {
		SenderAddr4 = senderAddr4;
	}
	public String getSenderTown() {
		return SenderTown;
	}
	public void setSenderTown(String senderTown) {
		SenderTown = senderTown;
	}
	public LocalDate getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public String getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public String getSenderMessage() {
		return SenderMessage;
	}
	public void setSenderMessage(String senderMessage) {
		SenderMessage = senderMessage;
	}
	public String getReceiverName() {
		return ReceiverName;
	}
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	public String getReceiverAddr1() {
		return ReceiverAddr1;
	}
	public void setReceiverAddr1(String receiverAddr1) {
		ReceiverAddr1 = receiverAddr1;
	}
	public String getReceiverAddr2() {
		return ReceiverAddr2;
	}
	public void setReceiverAddr2(String receiverAddr2) {
		ReceiverAddr2 = receiverAddr2;
	}
	public String getReceiverAddr3() {
		return ReceiverAddr3;
	}
	public void setReceiverAddr3(String receiverAddr3) {
		ReceiverAddr3 = receiverAddr3;
	}
	public String getReceiverAddr4() {
		return ReceiverAddr4;
	}
	public void setReceiverAddr4(String receiverAddr4) {
		ReceiverAddr4 = receiverAddr4;
	}
	public String getReceiverTown() {
		return ReceiverTown;
	}
	public void setReceiverTown(String receiverTown) {
		ReceiverTown = receiverTown;
	}
	public String getReceiverPhone() {
		return ReceiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		ReceiverPhone = receiverPhone;
	}
	public String getDeliveryInstructions() {
		return DeliveryInstructions;
	}
	public void setDeliveryInstructions(String deliveryInstructions) {
		DeliveryInstructions = deliveryInstructions;
	}
	public String getItemCode() {
		return ItemCode;
	}
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public String getItemDescription() {
		return ItemDescription;
	}
	public void setItemDescription(String itemDescription) {
		ItemDescription = itemDescription;
	}
	public long getQtyOrd() {
		return qtyOrd;
	}
	public void setQtyOrd(long qtyOrd) {
		this.qtyOrd = qtyOrd;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
