package test.restapi.phooms.resapi.repository;

import org.springframework.data.repository.CrudRepository;

import test.restapi.phooms.resapi.model.Department;

public interface DepartmentRepository extends CrudRepository<Department,Integer>{
    
}
