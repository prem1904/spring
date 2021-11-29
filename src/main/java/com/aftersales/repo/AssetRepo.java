package com.aftersales.repo;

import java.util.List;
import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.aftersales.domain.AssetManagement;

public interface AssetRepo extends MongoRepository<AssetManagement, String> {
    Optional<AssetManagement> findByAssetidAndCustomerid(String assetid,String customerid);
    List<AssetManagement> findByCustomerid(String customerid);

	
}
