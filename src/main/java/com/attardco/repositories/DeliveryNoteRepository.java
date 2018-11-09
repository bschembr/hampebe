	package com.attardco.repositories;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.attardco.entities.DeliveryNote;

	public interface DeliveryNoteRepository extends JpaRepository<DeliveryNote, Long> {

		 @Query(value = "select d from DeliveryNote d where d.DelOrdRef.DelOrdRef = :ord") 
		 public List<DeliveryNote> findDelNotesForOrder(@Param("ord") Long ord);
	}

