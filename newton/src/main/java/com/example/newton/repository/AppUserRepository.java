package com.example.newton.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.newton.model.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
}
