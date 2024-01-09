package test.restapi.phooms.resapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import test.restapi.phooms.resapi.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer>{
    
}
