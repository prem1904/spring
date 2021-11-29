package com.aftersales.repo;

import org.springframework.data.repository.CrudRepository;

import com.aftersales.domain.Role;

public interface RoleRepo extends CrudRepository<Role, Integer> {

}
