package com.aftersales.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aftersales.domain.SupportManagement;
import com.aftersales.repo.AssetRepo;
import com.aftersales.repo.SupportRepository;
import com.aftersales.repo.UserRepo;

@RestController
@RequestMapping("/support")
public class SupportController {
	private AssetRepo assetRepo;
	private SupportRepository supportRepo;
	public SupportController(SupportRepository supportRepo, AssetRepo assetRepo) {
		this.assetRepo = assetRepo;
		this.supportRepo=supportRepo;
	}
	@PostMapping
	@RequestMapping("/{customerid}/{assetid}")
	public void createSupport(@PathVariable(value="customerid") String customerid,@PathVariable(value="assetid")String assetid,
			@RequestParam  String id, @RequestBody SupportManagement supportManagement,
			@RequestParam String supportdate) {
		verifyCustomer(customerid,assetid);
		supportManagement.setAssetid(assetid);
		supportManagement.setCustomerid(customerid);
		supportManagement.setProviderid(id);
		supportManagement.setNextinspection(LocalDate.parse(supportdate));		
		this.supportRepo.save(new SupportManagement(supportManagement.getSupportcost(),
				supportManagement.getSupportdesc(), supportManagement.getAssetid(),
				supportManagement.getCustomerid(),supportManagement.getProviderid(), supportManagement.getNextinspection(),supportManagement.getProblem()));		
	}
	@GetMapping("/provider")
	public List<SupportManagement> getSupportServices(@RequestParam String serviceid){
		return this.supportRepo.findByProviderid(serviceid);
	}
	
	@GetMapping("/customer")
	public List<SupportManagement> getSupport(@RequestParam String customerid){
		return this.supportRepo.findByCustomerid(customerid);
	}
	private void verifyCustomer(String customerid, String assetid) {
		this.assetRepo.findByAssetidAndCustomerid(assetid, customerid).orElseThrow(()->
		new ResourceNotFoundException(assetid+" "+customerid));
		
	}
	
	

}
