package com.example.newton.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.newton.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
