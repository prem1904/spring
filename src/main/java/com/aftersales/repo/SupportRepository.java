package com.aftersales.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aftersales.domain.SupportManagement;

public interface SupportRepository extends CrudRepository<SupportManagement, String > {
	
	List<SupportManagement> findByProviderid(String providerid);
	
	List<SupportManagement> findByCustomerid(String customerid);
	

}
