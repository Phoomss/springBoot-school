package com.example.newton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.newton.model.Camera;
import com.example.newton.repository.CameraRepository;
import com.example.newton.service.CameraService;

@RestController
@RequestMapping("/camera")
public class CameraController {
    @Autowired
    private CameraService cameraService;

    @Autowired
    private CameraRepository cameraRepository;

    @GetMapping
    public ResponseEntity<?> getAllCamera() {
        return cameraService.getAllCamera();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCameraById(@PathVariable int id) {
        return cameraService.getCameraById(id);
    }

    @GetMapping("/ip/{ipAddress}")
    public List<Camera> getCamerasByIpAddress(@PathVariable String ipAddress) {
        return cameraRepository.findByIpAddress(ipAddress);
    }

    @GetMapping("/location/{location}")
    public List<Camera> getCamerasByLocation(@PathVariable String location) {
        return cameraRepository.findByLocation(location);
    }

    @PostMapping
    public ResponseEntity<?> createCamera(@RequestBody Camera camera) {
        return cameraService.createCamera(camera);
    }
}
