package com.jovana.springbootrestfulwebservices.repository;

import com.jovana.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
