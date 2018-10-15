package com.attardco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.attardco.entities.DeliveryNote;
import com.attardco.entities.DeliveryOrder;
import com.attardco.repositories.DeliveryNoteRepository;
import com.attardco.repositories.DeliveryOrderRepository;


@SpringBootApplication
public class HampersBackendApplication implements CommandLineRunner {
	
	@Autowired
	private DeliveryOrderRepository deliveryOrderRepository;	
	
	@Autowired
	private DeliveryNoteRepository deliveryNoteRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(HampersBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
					
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		deliveryOrder.setCustName("Testing Customer Name");
		deliveryOrder.setCustRef("Testing Customer Ref");
		
		DeliveryNote deliveryNoteHeader = new DeliveryNote();
		deliveryNoteHeader.setDelOrdRef(deliveryOrder);
		deliveryNoteHeader.setDeliveryInstructions("test delivery instructions1");		
		
		DeliveryNote deliveryNoteHeader2 = new DeliveryNote();
		deliveryNoteHeader2.setDelOrdRef(deliveryOrder);
		deliveryNoteHeader2.setDeliveryInstructions("test delivery instructions2");

		deliveryOrderRepository.save(deliveryOrder);
		deliveryNoteRepository.save(deliveryNoteHeader);
		deliveryNoteRepository.save(deliveryNoteHeader2);
	}

}
