package com.attardco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.attardco.entities.ItemsView;

public interface ItemsViewRepository extends JpaRepository<ItemsView, Long> {

	 @Query(value = "select sysref, code, desc1 from dbo.view_items where dbo.view_items.CODE like 'HP171%' or dbo.view_items.CODE like 'HP172%' ", nativeQuery = true) 
	 List<ItemsView> findHampersItems();
}
