	package com.attardco.repositories;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.attardco.entities.DeliveryNote;

	public interface DeliveryNoteRepository extends JpaRepository<DeliveryNote, Long> {

		 @Query(value = "select d from DeliveryNote d where d.DelOrdRef.DelOrdRef = :ord") 
		 public List<DeliveryNote> findDelNotesForOrder(@Param("ord") Long ord);

		 @Transactional
		 @Modifying
		 @Query(value = "update DeliveryNote d set d.Locked = true where d.DelNoteRef = :dnoteRef") 
		 public void lockDelNote(@Param("dnoteRef") Long dnoteRef);

		 @Transactional
		 @Modifying
		 @Query(value = "update DeliveryNote d set d.Locked = false where d.DelNoteRef = :dnoteRef") 
		 public void unlockDelNote(@Param("dnoteRef") Long dnoteRef);
	}

