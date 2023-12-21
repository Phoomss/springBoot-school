package nvc.it.phooms.usedcar;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nvc.it.phooms.usedcar.model.Car;
import nvc.it.phooms.usedcar.model.Owner;
import nvc.it.phooms.usedcar.repository.CarRepository;
import nvc.it.phooms.usedcar.repository.OwerRepository;

@SpringBootApplication
public class UsedcarApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(UsedcarApplication.class, args);
	}

	private static final Logger Logger = LoggerFactory.getLogger(UsedcarApplication.class);

	private final CarRepository carRepository;
	private final OwerRepository owerRepository;

	public UsedcarApplication(CarRepository carRepository, OwerRepository owerRepository) {
		this.carRepository = carRepository;
		this.owerRepository = owerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Jhonson");
		Owner owner2 = new Owner("Mary", "Robinson");
		owerRepository.saveAll(Arrays.asList(owner1, owner2));
		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000,owner1 ));
		carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000,owner2 ));
		carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000,owner1 ));

		// Fetch all cars and log to console
		for (Car car : carRepository.findAll()) {
			Logger.info("brand: {}, model: {}",
					car.getBrand(), car.getModel());
		}
		 
		 // Fetch all owners and log to console
for (Owner owner : owerRepository .findAll()) {
	Logger.info("FirstName: {}, LastName: {}",
	owner.getFristName (), owner.getLastName());
	}
	}
}