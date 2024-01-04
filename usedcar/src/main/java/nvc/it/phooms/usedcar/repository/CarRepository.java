package nvc.it.phooms.usedcar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nvc.it.phooms.usedcar.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findByPrice(Integer price);

    List<Car> findByColor(String color);

    List<Car> findByModelYear(int modelYear);
}
