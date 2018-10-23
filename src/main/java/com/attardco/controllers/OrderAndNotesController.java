package com.attardco.controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attardco.entities.DeliveryNote;
import com.attardco.entities.DeliveryOrder;
import com.attardco.entities.ItemsView;
import com.attardco.repositories.DeliveryNoteRepository;
import com.attardco.repositories.DeliveryOrderRepository;
import com.attardco.repositories.ItemsViewRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class OrderAndNotesController {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private DeliveryOrderRepository deliveryOrderRepository;

	@GetMapping("/delorders")
	public List<DeliveryOrder> getDelOrders() {
		return deliveryOrderRepository.findAll();
	}

	@GetMapping("/delorder/{id}")
	public DeliveryOrder getDelOrder(@PathVariable Long id) {
		return deliveryOrderRepository.findById(id).get();
	}

	@DeleteMapping("/delorder/{id}")
	public boolean deleteDelOrder(@PathVariable Long id) {
		deliveryOrderRepository.deleteById(id);
		return true;
	}

	@PutMapping("/delorder")
	public DeliveryOrder updateDelOrder(@RequestBody DeliveryOrder deliveryOrder) {
		return deliveryOrderRepository.save(deliveryOrder);
	}

	@PostMapping("/delorder")
	public DeliveryOrder createDelOrder(@RequestBody DeliveryOrder deliveryOrder) {
		return deliveryOrderRepository.save(deliveryOrder);
	}	
	
	// ---------------------------------------------
	// CRUD OPERATIONS FOR DELIVERY NOTES
	// ---------------------------------------------
	
	@Autowired
	private DeliveryNoteRepository deliveryNoteRepository;

	@GetMapping("/delorders/delnotes")
	public List<DeliveryNote> getDelNotes() {
		return deliveryNoteRepository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/delorder/{id}/delnotes")
	public List<DeliveryNote> getOrderDelNotes(@PathVariable Long id) {
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("rawtypes")
		SQLQuery sqlQuery = session.createNativeQuery("SELECT delnotes.*\r\n" + 
				"FROM [dbo].[DeliveryNote] delnotes\r\n" + 
				"inner join [dbo].[DeliveryOrder] delorders on delorders.DelOrdRef = Delnotes.delOrderRef_id\r\n" + 
				"where Delnotes.delOrderRef_id =  " + id);
		return sqlQuery.list();
	}

	@GetMapping("/delnote/{id}")
	public DeliveryNote getDelNote(@PathVariable Long id) {
		return deliveryNoteRepository.findById(id).get();
	}

	@DeleteMapping("/delnote/{id}")
	public boolean deleteDelNote(@PathVariable Long id) {
		deliveryNoteRepository.deleteById(id);
		return true;
	}

	@PutMapping("/delnote")
	public DeliveryNote updateDelNote(@RequestBody DeliveryNote deliveryNote) {
		return deliveryNoteRepository.save(deliveryNote);
	}

	@PostMapping("/delnote")
	public DeliveryNote createDelNote(@RequestBody DeliveryNote deliveryNote) {
		return deliveryNoteRepository.save(deliveryNote);
        
	}	

	// ---------------------------------------------
	// OPERATIONS FOR ITEMSVIEW
	// ---------------------------------------------
	
	@Autowired
	private ItemsViewRepository itemsViewRepository;

	// @SuppressWarnings("unchecked")
	@GetMapping("/items")
	public List<ItemsView> getItemsView() { 
		return itemsViewRepository.findHampersItems();
	}
	
}