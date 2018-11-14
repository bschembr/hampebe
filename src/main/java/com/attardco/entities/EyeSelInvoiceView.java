package com.attardco.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;


@Entity
@SqlResultSetMapping(
        name = "EyeSelInvoiceViewMapping",
        entities = @EntityResult(
                entityClass = EyeSelInvoiceView.class,
                fields = {
                    @FieldResult(name = "SYSREF", column = "SYSREF"),
                    @FieldResult(name = "SalesOrder", column = "SalesOrder"),
                    @FieldResult(name = "ClientCode", column = "ClientCode"),
                    @FieldResult(name = "ItemCode", column = "ItemCode"),
                    @FieldResult(name = "Qty", column = "Qty"),
                    @FieldResult(name = "Display", column = "Display"),
                    @FieldResult(name = "InvNum", column = "InvNum")}))

@NamedNativeQuery(name = "getInvoiceDetails",
		query = "SELECT SoD.SYSREF as SYSREF, SoD.HEADERSYSREF as SalesOrder, SoH.ACCOUNT as ClientCode, Inp.CODE as ItemCode, SoD.BASEQTY * -1 as Qty, SoD.DISPLAY as Display, SoH.REFERENCE as InvNum "
				+ "from EyeSelServer.TEST_FOOD.dbo.SOPOSTHD SoH "
				+ "inner join EyeSelServer.TEST_FOOD.dbo.SOPOSTDT SoD on SoH.SYSREF = SoD.HEADERSYSREF "
				+ "inner join EyeSelServer.TEST_FOOD.dbo.INPROFIL InP on SoD.Profilesysref = InP.SYSREF "
				+ "WHERE (SOh.REFERENCE = :invNum)",
		resultClass = EyeSelInvoiceView.class )


public class EyeSelInvoiceView {
	@Id
	private java.math.BigDecimal SYSREF;
	private java.math.BigDecimal SalesOrder;
	private String ClientCode;
	private String ItemCode;
	private Long Qty;
	private String Display;
	private java.math.BigDecimal InvNum;
	
	public EyeSelInvoiceView() {};
	
	public java.math.BigDecimal getSYSREF() {
		return SYSREF;
	}
	public void setSYSREF(java.math.BigDecimal sYSREF) {
		SYSREF = sYSREF;
	}
	public java.math.BigDecimal getSalesOrder() {
		return SalesOrder;
	}
	public void setSalesOrder(java.math.BigDecimal salesOrder) {
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
	public java.math.BigDecimal getInvNum() {
		return InvNum;
	}
	public void setInvNum(java.math.BigDecimal invNum) {
		InvNum = invNum;
	}

	
}
