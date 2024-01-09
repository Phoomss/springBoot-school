package test.restapi.phooms.resapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.restapi.phooms.resapi.model.Department;
import test.restapi.phooms.resapi.repository.DepartmentRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseEntity<?> getAllDepartments() {
        Optional<Iterable<Department>> dOptional = Optional.ofNullable(departmentRepository.findAll());

        if (dOptional.isPresent() && dOptional.get().iterator().hasNext()) {
            Iterable<Department> departments = dOptional.get();
            return ResponseEntity.ok(departments);
        } else {
            Map<String, String> resMap = new HashMap<>();
            resMap.put("message", "No department found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resMap);
        }
    }

    public ResponseEntity<?> getDepartmentById(int id) {
        Optional<Department> dOptional = departmentRepository.findById(id);

        if (dOptional.isPresent()) {
            Department department = dOptional.get();
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Department ID: " + id + " not found"));
        }
    }

    public ResponseEntity<?> createDepartment(Department department) {
        Department newDepartment = departmentRepository.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDepartment);
    }

    public ResponseEntity<Map<String, Object>> editDepartment(int id, Department updatedDepartment) {
        Optional<Department> existingDepartmentOptional = departmentRepository.findById(id);

        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();

            existingDepartment.setName(updatedDepartment.getName());

            Department savedDepartment = departmentRepository.save(existingDepartment);

            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("message", "Department updated successfully");
            responseMap.put("data", savedDepartment);

            return ResponseEntity.ok(responseMap);
        } else {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("message", "Department not found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }
    }

    public ResponseEntity<?> deleteDepartment(int id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        Map<String, String> responseMap = new HashMap<>();

        if (departmentOptional.isPresent()) {
            // has data
            departmentRepository.delete(departmentOptional.get());
            responseMap.put("message", "Delete data complete");
            return ResponseEntity.ok(responseMap);
        } else {
            responseMap.put("message", "Cannot find department with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }
    }
}
