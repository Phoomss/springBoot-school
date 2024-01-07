package test.restapi.phooms.resapi.repository;

import org.springframework.data.repository.CrudRepository;

import test.restapi.phooms.resapi.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
