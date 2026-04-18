package com.userService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userService.Entity.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByEmail(String Email);
}
