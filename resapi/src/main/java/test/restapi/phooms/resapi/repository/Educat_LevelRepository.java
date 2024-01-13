package test.restapi.phooms.resapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import test.restapi.phooms.resapi.model.Educat_level;

@Repository
public interface Educat_LevelRepository extends CrudRepository<Educat_level,Integer> {

}
