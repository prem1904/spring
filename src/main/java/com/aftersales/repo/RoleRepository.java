package com.aftersales.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.aftersales.domain.ERole;
import com.aftersales.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	 Optional<Role> findByName(ERole name);
	}
