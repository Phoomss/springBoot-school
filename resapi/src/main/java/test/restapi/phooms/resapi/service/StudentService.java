package test.restapi.phooms.resapi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional; // Import Optional from java.util
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import test.restapi.phooms.resapi.model.Student;
import test.restapi.phooms.resapi.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> getAllStudent() { // Corrected the method name
        Optional<Iterable<Student>> sOptional = Optional.ofNullable(studentRepository.findAll());

        if (sOptional.isPresent() && sOptional.get().iterator().hasNext()) {
            Iterable<Student> students = sOptional.get();
            return ResponseEntity.ok(students);
        } else {
            Map<String, String> resMap = new HashMap<>();
            resMap.put("message", "No students found"); // Corrected the message
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(resMap);
        }
    }
}
