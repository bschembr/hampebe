package com.attardco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.attardco.entities.ClientsView;

public interface ClientsViewRepository extends JpaRepository<ClientsView, String> {

	 @Query(value = "SELECT ACCOUNT, NAME, ADDRESSLN1, ADDRESSLN2, ADDRESSLN3, ADDRESSLN4, TOWN FROM dbo.view_clients", nativeQuery = true) 
	 List<ClientsView> listClients();

}
