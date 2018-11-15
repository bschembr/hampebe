package com.attardco.entities;

import javax.persistence.Column;
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
                	@FieldResult(name = "ROW", column = "ROW"),
                    @FieldResult(name = "ClientCode", column = "ClientCode"),
                    @FieldResult(name = "ItemCode", column = "ItemCode"),
                    @FieldResult(name = "ItemQty", column = "ItemQty"),
                    @FieldResult(name = "InvNum", column = "InvNum")}))

@NamedNativeQuery(name = "getInvoiceDetails",
		query = "SELECT ROW_NUMBER() OVER(ORDER BY SoD.SYSREF) as ROW, SoH.ACCOUNT as ClientCode, Inp.CODE as ItemCode, SUM(SoD.BASEQTY * -1) as ItemQty, SoH.REFERENCE as InvNum  "
				+ "from EyeSelServer.TEST_FOOD.dbo.SOPOSTHD SoH "
				+ "inner join EyeSelServer.TEST_FOOD.dbo.SOPOSTDT SoD on SoH.SYSREF = SoD.HEADERSYSREF "
				+ "inner join EyeSelServer.TEST_FOOD.dbo.INPROFIL InP on SoD.Profilesysref = InP.SYSREF "
				+ "WHERE (SOh.REFERENCE = :invNum) "
				+ "group by SoD.SYSREF, SoH.ACCOUNT, Inp.CODE, SoH.REFERENCE",
		resultClass = EyeSelInvoiceView.class )


public class EyeSelInvoiceView {
	@Id
	@Column(name = "ROW", updatable = false, nullable = false)
	private Long ROW;
	private String ClientCode;
	private String ItemCode;
	private Long ItemQty;
	private java.math.BigDecimal InvNum;
	
	public EyeSelInvoiceView() {}

	public Long getROW() {
		return ROW;
	}

	public void setROW(Long rOW) {
		ROW = rOW;
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

	public Long getItemQty() {
		return ItemQty;
	}

	public void setItemQty(Long itemQty) {
		ItemQty = itemQty;
	}

	public java.math.BigDecimal getInvNum() {
		return InvNum;
	}

	public void setInvNum(java.math.BigDecimal invNum) {
		InvNum = invNum;
	}

	
}
