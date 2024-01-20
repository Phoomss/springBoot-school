package com.example.newton.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.newton.model.Camera;

import java.util.List;

@RepositoryRestResource(path = "camera")
public interface CameraRepository extends CrudRepository<Camera, Integer> {

    List<Camera> findByIpAddress(@Param("ipAddress") String ipAddress);

    List<Camera> findByLocationContaining(@Param("location") String location);
}
