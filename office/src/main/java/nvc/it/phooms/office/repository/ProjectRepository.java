package nvc.it.phooms.office.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nvc.it.phooms.office.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    List<Project>findByNameContaining(String name);
}
