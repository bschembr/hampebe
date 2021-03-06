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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attardco.entities.ClientsView;
import com.attardco.entities.DeliveryNote;
import com.attardco.entities.DeliveryOrder;
import com.attardco.entities.EyeSelInvoiceView;
import com.attardco.entities.ItemsView;
import com.attardco.repositories.ClientsViewRepository;
import com.attardco.repositories.DeliveryNoteRepository;
import com.attardco.repositories.DeliveryOrderRepository;
import com.attardco.repositories.EyeSelInvoiceRepository;
import com.attardco.repositories.ItemsViewRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@Transactional( propagation = Propagation.SUPPORTS, 
				readOnly = true )
@CrossOrigin(origins= { "http://localhost:4200", "http://acots" }, allowedHeaders="*")
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
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
	public boolean deleteDelOrder(@PathVariable Long id) {
		deliveryOrderRepository.deleteById(id);
		return true;
	}

	@PutMapping("/delorder")
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
	public DeliveryOrder updateDelOrder(@RequestBody DeliveryOrder deliveryOrder) {
		return deliveryOrderRepository.save(deliveryOrder);
	}

	@PostMapping("/delorder")
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
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
	
	@GetMapping("/delorder/{id}/delnotes")
	public List<DeliveryNote> getDelNotesForOrder(@PathVariable Long id) {
		return deliveryNoteRepository.findDelNotesForOrder(id);
	}
	
	@GetMapping("/delnote/{id}")
	public DeliveryNote getDelNote(@PathVariable Long id) {
		return deliveryNoteRepository.findById(id).get();
	}

	@DeleteMapping("/delnote/{id}")
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
	public boolean deleteDelNote(@PathVariable Long id) {
		deliveryNoteRepository.deleteById(id);
		return true;
	}

	@PutMapping("/delnote")
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
	public DeliveryNote updateDelNote(@RequestBody DeliveryNote deliveryNote) {
		return deliveryNoteRepository.save(deliveryNote);
	}


	@PostMapping("/delnote")
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
	public DeliveryNote createDelNote(@RequestBody DeliveryNote deliveryNote) {
		return deliveryNoteRepository.save(deliveryNote);
        
	}

	@PutMapping("/lockdelnote/{id}")
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
	public Boolean lockDelNote(@PathVariable Long id) {
		deliveryNoteRepository.lockDelNote(id);
		return true;
	}

	@PutMapping("/unlockdelnote/{id}")
	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly = false)
	public Boolean unlockDelNote(@PathVariable Long id) {
		deliveryNoteRepository.unlockDelNote(id);
		return true;
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
	

	// ---------------------------------------------
	// OPERATIONS FOR CLIENTSVIEW
	// ---------------------------------------------
	
	@Autowired
	private ClientsViewRepository clientViewRepository;

	// @SuppressWarnings("unchecked")
	@GetMapping("/clients")
	public List<ClientsView> getClientsView() { 
		return clientViewRepository.listClients();
	}

	
	// ---------------------------------------------
	// OPERATIONS FOR EYESEL INVOICES
	// ---------------------------------------------

	@Autowired
	private EyeSelInvoiceRepository eyeSelInvoiceRepository;
	
	@GetMapping("/invoice/{inv}")
	public List<EyeSelInvoiceView> getEyeSelInvDet(@PathVariable Long inv){
		return eyeSelInvoiceRepository.getEyeSelInvLines(inv);
	}
}