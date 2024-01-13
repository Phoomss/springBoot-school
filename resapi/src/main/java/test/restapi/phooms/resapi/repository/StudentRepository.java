package test.restapi.phooms.resapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import test.restapi.phooms.resapi.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
