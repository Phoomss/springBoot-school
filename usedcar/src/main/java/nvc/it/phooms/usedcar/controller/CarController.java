package nvc.it.phooms.usedcar.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import nvc.it.phooms.usedcar.model.Car;
import nvc.it.phooms.usedcar.model.Owner;
import nvc.it.phooms.usedcar.repository.CarRepository;
import nvc.it.phooms.usedcar.repository.OwerRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired

    private CarRepository carRepository;

    @Autowired
    private OwerRepository owerRepository;

    @GetMapping("")
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Car> carOptional = carRepository.findById(id);
        Map<String, String> responseMap = new HashMap<>();

        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            responseMap.put("compeete" + car);
            return ResponseEntity.ok();
        } else {
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("message", "Car with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }
    }

    @GetMapping("/color/{color}")
    public Iterable<Car> getByColor(@PathVariable String color) {
        return carRepository.findByColor(color);
    }

    @GetMapping("/year/{modelYear}")
    public Iterable<Car> getByModelYear(@PathVariable int modelYear) {
        return carRepository.findByModelYear(modelYear);
    }

    @PostMapping("")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        Car newCar = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable int id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        Map<String, String> responseMap = new HashMap<>();

        if (optionalCar.isPresent()) {
            // has data
            carRepository.delete(optionalCar.get());
            responseMap.put("message", "Delete data complete");
        } else {
            responseMap.put("message", "Cannot find car id " + id);
        }
        ResponseEntity<Map<String, String>> response = ResponseEntity.ok(responseMap);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> editById(@PathVariable int id, @RequestBody Car car) {
        // get old data
        Optional<Car> oldCar = carRepository.findById(id);
        Map<String, Object> responseMap = new HashMap<>();

        if (oldCar.isPresent()) {
            Car oldCarData = oldCar.get();
            oldCarData.setBrand(car.getBrand());
            oldCarData.setColor(car.getColor());
            oldCarData.setModel(car.getModel());
            oldCarData.setModelYear(car.getModelYear());
            oldCarData.setPrice(car.getPrice());
            oldCarData.setRegistrationNumber(car.getRegistrationNumber());
            carRepository.save(oldCarData);
            responseMap.put("message", "Edit car id " + id + " complete.");
            responseMap.put("data", oldCarData);
        } else {
            responseMap.put("message", "Cannot find car id " + id);
        }

        ResponseEntity<Map<String, Object>> response = ResponseEntity.ok(responseMap);

        return response;
    }

    @PatchMapping("/{id}/owner/{ownerId}")
    public ResponseEntity<Map<String, Object>> updateCarOwner(@PathVariable int id, @PathVariable int ownerId) {
        Optional<Car> oldCar = carRepository.findById(id);
        Optional<Owner> owner = owerRepository.findById(ownerId);

        Map<String, Object> responseMap = new HashMap<>();

        if (oldCar.isPresent()) {
            Car oldCarData = oldCar.get();
            if (owner.isPresent()) {
                Owner ownerData = owner.get();
                oldCarData.setOwner(ownerData);

                carRepository.save(oldCarData);

                responseMap.put("message", "Update car owner for car id " + id + " complete.");
                responseMap.put("data", oldCarData);
            } else {
                responseMap.put("message", "Cannot find owner with id " + ownerId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
            }
        } else {
            responseMap.put("message", "Cannot find car with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        return ResponseEntity.ok(responseMap);
    }

}
