	package com.aftersales.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.jvnet.staxex.Base64EncoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aftersales.domain.AccessInterface;
import com.aftersales.domain.AssetManagement;
import com.aftersales.repo.AssetRepo;
import com.aftersales.repo.SupportRepository;
import com.aftersales.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/asset")
public class AssetController {
	private UserRepo userRepo;
	private AssetRepo assetrepo;
	private SupportRepository supportRepository;
	@Autowired
	public AssetController(UserRepo userRepo,AssetRepo assetrepo,SupportRepository supportRepository) {
		this.assetrepo = assetrepo;
		this.userRepo=userRepo;
		this.supportRepository=supportRepository;
	}
	@PostMapping
	@RequestMapping("/{customerid}")
	public void assetController(@PathVariable(value="customerid") String customerId,
			@RequestBody AssetManagement assetManagement, @RequestParam String purchase) throws JsonProcessingException {
		verifyCustomer(customerId);
		assetManagement.setCustomerid(customerId);
		assetManagement.setPurchasedate(LocalDate.parse(purchase));
		assetManagement=this.assetrepo.save(new AssetManagement(assetManagement.getAssetname(),assetManagement.getAssetcode(),assetManagement.getCustomerid(), 
				assetManagement.getPrice(),assetManagement.getPurchasedate(),assetManagement.getCategory(),assetManagement.getManufacturer()));
		
		AccessInterface accessInterface= new AccessInterface(assetManagement.getAssetid(),assetManagement.getCustomerid());		
		assetManagement.setQuickreponse(Base64.getEncoder().encodeToString(new ObjectMapper().writeValueAsString(accessInterface).getBytes()));
		this.assetrepo.save(assetManagement);
	}
	@GetMapping
	public AssetManagement getAsset(@RequestParam String id) throws JsonMappingException, JsonProcessingException {
		AccessInterface accessInterface= new ObjectMapper().readValue(new String(Base64.getDecoder().decode(id)), AccessInterface.class);  
		return this.assetrepo.findByAssetidAndCustomerid(accessInterface.getAssetid(), accessInterface.getCustomerid()).get();
		
	}
	
	private void verifyCustomer(String customerId) {
		this.userRepo.findById(customerId)
		.orElseThrow(()-> new ResourceNotFoundException("Customer is not available" + customerId));
	}
	
	
	 
	 
	 
	

}
