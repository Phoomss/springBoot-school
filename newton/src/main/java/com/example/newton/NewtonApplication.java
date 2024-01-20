package com.example.newton;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.newton.model.AppUser;
import com.example.newton.model.Camera;
import com.example.newton.model.Event;
import com.example.newton.repository.AppUserRepository;
import com.example.newton.repository.CameraRepository;
import com.example.newton.repository.EventRepository;

@SpringBootApplication
public class NewtonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NewtonApplication.class, args);
	}

	private final CameraRepository cameraRepository;

	private final EventRepository eventRepository;

	private final AppUserRepository userRepository;

	public NewtonApplication(CameraRepository cameraRepository, EventRepository eventRepository,
			AppUserRepository userRepository) {
		this.cameraRepository = cameraRepository;
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Camera camera1 = new Camera("192.168.1.11", "Machine 1", "CAM-001");
		Camera camera2 = new Camera("192.168.1.12", "Machine 2", "CAM-002");

		cameraRepository.saveAll(Arrays.asList(camera1, camera2));

		eventRepository.save(new Event(200, camera1));
		eventRepository.save(new Event(300, camera1));
		eventRepository.save(new Event(200, camera2));
		eventRepository.save(new Event(300, camera2));

		userRepository
				.save(new AppUser("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));
		// Username: admin, password: admin
		userRepository
				.save(
						new AppUser("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}
}
