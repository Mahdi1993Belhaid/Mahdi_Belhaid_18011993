package com.belhaid.mahdi.belhaid_mahdi_18011993.repositories;

import java.util.Optional;

import com.belhaid.mahdi.belhaid_mahdi_18011993.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

}
