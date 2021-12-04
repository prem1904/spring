package com.aftersales.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aftersales.domain.Delivery;

public interface DeliveryRepo extends CrudRepository<Delivery, String> {
	Optional<Delivery> findByDeliveryid(String deliveryid);
	Optional<Delivery> findByDeliveryidAndIssuedate(String deliveryid, String issuedate);		
	
}
