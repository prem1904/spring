package com.aftersales.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.aftersales.domain.UserManagement;

public interface UserRepo extends MongoRepository<UserManagement, String> {

}
