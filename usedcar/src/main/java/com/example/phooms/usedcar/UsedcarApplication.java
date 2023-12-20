package com.example.phooms.usedcar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.phooms.usedcar.repository.CarRepository;
import com.example.phooms.usedcar.model.Car;

@SpringBootApplication
public class UsedcarApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(UsedcarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UsedcarApplication.class, args);
	}

	private final CarRepository carRepository;

	public UsedcarApplication(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023,59000));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020,29000));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212",2022, 39000));
		// Fetch all cars and log to console
		for (Car car : carRepository.findAll()) {
			logger.info("brand: {}, model: {}",
					car.getBrand(), car.getModel());
		}
	}

}
