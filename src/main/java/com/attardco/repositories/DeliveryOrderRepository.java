package com.attardco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attardco.entities.DeliveryOrder;

@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {

}
