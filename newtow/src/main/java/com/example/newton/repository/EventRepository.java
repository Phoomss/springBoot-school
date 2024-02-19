package com.example.newton.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.newton.model.Event;

@RepositoryRestResource(path = "event")
public interface EventRepository extends CrudRepository<Event, Integer> {

}
