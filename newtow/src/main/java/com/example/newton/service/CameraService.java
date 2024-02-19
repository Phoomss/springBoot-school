package com.example.newton.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newton.model.Camera;
import com.example.newton.repository.CameraRepository;

@Service
public class CameraService {
    @Autowired
    private CameraRepository cameraRepository;

    public ResponseEntity<?> getAllCamera() {
        Optional<Iterable<Camera>> cOptional = Optional.ofNullable(cameraRepository.findAll());

        if (cOptional.isPresent() && cOptional.get().iterator().hasNext()) {
            Iterable<Camera> cameras = cOptional.get();
            return ResponseEntity.ok(cameras);
        } else {
            Map<String, String> resMap = new HashMap<>();
            resMap.put("message", "No educate level found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resMap);
        }
    }

    public ResponseEntity<?> getCameraById(int id) {
        Optional<Camera> cOptional = cameraRepository.findById(id);

        if (cOptional.isPresent()) {
            Camera camera = cOptional.get();
            return ResponseEntity.ok(camera);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Department ID: " + id + " not found"));
        }
    }

    public ResponseEntity<?> createCamera(Camera camera) {
        Camera newCamera = cameraRepository.save(camera);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCamera);
    }
}
