package com.aftersales.repo;


import org.springframework.data.repository.CrudRepository;

import com.aftersales.domain.UserManagement;

public interface UserRepo extends CrudRepository<UserManagement, String> {

}
