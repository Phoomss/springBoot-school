package test.restapi.phooms.resapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.restapi.phooms.resapi.model.Educat_level;
import test.restapi.phooms.resapi.service.Educate_LevelService;

@RestController
@RequestMapping("/educate-level")
public class Educate_LevelController {
    @Autowired
    private Educate_LevelService educate_LevelService;

    @GetMapping()
    public ResponseEntity<?> getAllEducateLevel() {
        return educate_LevelService.getAllEducateLevel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEducateLevelById(@PathVariable int id) {
        return educate_LevelService.getEducate_LevelById(id);
    }

    @PostMapping()
    public ResponseEntity<?> createEducate_Level(@RequestBody Educat_level educat_level) {
        return educate_LevelService.createEducate_Level(educat_level);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editEducate_level(@PathVariable int id, @RequestBody Educat_level educat_level) {
        return educate_LevelService.editEducate_level(id, educat_level);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable int id) {
        return educate_LevelService.deleteEducate_level(id);
    }
}
