package com.attardco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.attardco.entities.EyeSelInvoiceView;
import com.attardco.entities.ItemsView;

public interface EyeSelInvoiceRepository extends JpaRepository<ItemsView, Long> {

	 
	String QueryString = "SELECT SoD.SYSREF as SYSREF, SoD.HEADERSYSREF as SalesOrder, SoH.ACCOUNT as ClientCode, Inp.CODE as ItemCode, SoD.BASEQTY as Qty, SoD.DISPLAY as Display, SoH.REFERENCE as InvNum " +
							"from dbo.SOPOSTHD SoH " +
							"inner join dbo.SOPOSTDT SoD on SoH.SYSREF = SoD.HEADERSYSREF " +
							"inner join dbo.INPROFIL InP on SoD.Profilesysref = InP.SYSREF " +
							"WHERE (SOh.REFERENCE = :invNum)";
	@Query(value = QueryString, nativeQuery = true)
	public List<EyeSelInvoiceView> getEyeSelInvLines(@Param("invNum") Long invNum);
}
