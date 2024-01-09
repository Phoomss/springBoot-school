package test.restapi.phooms.resapi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.restapi.phooms.resapi.model.Educat_level;
import test.restapi.phooms.resapi.repository.Educat_LevelRepository;

@Service
public class Educate_LevelService {

    @Autowired
    private Educat_LevelRepository educat_LevelRepository;

    public ResponseEntity<?> getAllEducateLevel() {
        Optional<Iterable<Educat_level>> educateLevelOptional = Optional.ofNullable(educat_LevelRepository.findAll());

        if (educateLevelOptional.isPresent() && educateLevelOptional.get().iterator().hasNext()) {
            Iterable<Educat_level> educateLevels = educateLevelOptional.get();
            return ResponseEntity.ok(educateLevels);
        } else {
            Map<String, String> resMap = new HashMap<>();
            resMap.put("message", "No educate level found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resMap);
        }
    }

    public ResponseEntity<?> getEducate_LevelById(int id) {
        Optional<Educat_level> edOptional = educat_LevelRepository.findById(id);

        if (edOptional.isPresent()) {
            Educat_level educat_level = edOptional.get();
            return ResponseEntity.ok(educat_level);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Educate-Level ID: " + id + "not found"));
        }
    }

    public ResponseEntity<?> createEducate_Level(Educat_level educat_level) {
        try {
            Educat_level newEducat_level = educat_LevelRepository.save(educat_level);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEducat_level);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Educat_level");
        }
    }

    public ResponseEntity<?> editEducate_level(int id, Educat_level educat_level) {
        try {
            Optional<Educat_level> oldEducate = educat_LevelRepository.findById(id);
            Map<String, String> reMap = new HashMap<>();

            if (oldEducate.isPresent()) {
                Educat_level oldEducateData = oldEducate.get();
                oldEducateData.setName(educat_level.getName());

                // Commit transaction
                educat_LevelRepository.save(oldEducateData);

                // การแก้ไขเสร็จสิ้น
                reMap.put("message", "Educate_level updated successfully" + id);
                return ResponseEntity.ok(reMap);
            } else {
                // ไม่พบ Educate_level ที่ต้องการแก้ไข
                reMap.put("error", "Educate_level not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reMap);
            }
        } catch (Exception e) {
            // การจัดการข้อผิดพลาด
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
        }
    }

    // public ResponseEntity<?> updateEducate_levelDepartment(int id, int
    // departmentId) {
    // try {

    // } catch (Exception e) {
    // // TODO: handle exception
    // }
    // }

    public ResponseEntity<?> deleteEducate_level(int id) {
        try {
            Optional<Educat_level> educate_levelOptional = educat_LevelRepository.findById(id);
            Map<String, String> responseMap = new HashMap<>();

            if (educate_levelOptional.isPresent()) {
                // Educate_level found, proceed with deletion
                educat_LevelRepository.delete(educate_levelOptional.get());
                responseMap.put("message", "Educate_level deleted successfully");
                return ResponseEntity.ok(responseMap);
            } else {
                // Educate_level not found, return a meaningful response
                responseMap.put("error", "Educate_level not found with ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
            }
        } catch (Exception e) {
            // Handle exceptions and provide a meaningful response
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
        }
    }

}
