package com.montstudio.segaretrogames.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.montstudio.segaretrogames.backend.integration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
