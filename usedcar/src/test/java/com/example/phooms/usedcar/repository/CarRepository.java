package com.example.phooms.usedcar.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.phooms.usedcar.controller.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}