package test.restapi.phooms.resapi;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import test.restapi.phooms.resapi.model.Department;
import test.restapi.phooms.resapi.model.Educat_level;
import test.restapi.phooms.resapi.model.Student;
import test.restapi.phooms.resapi.repository.DepartmentRepository;
import test.restapi.phooms.resapi.repository.Educat_LevelRepository;
import test.restapi.phooms.resapi.repository.StudentRepository;

@SpringBootApplication
public class ResapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ResapiApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(ResapiApplication.class);

	private final StudentRepository studentRepository;
	private final DepartmentRepository departmentRepository;
	private final Educat_LevelRepository educat_LevelRepository;

	public ResapiApplication(StudentRepository studentRepository, DepartmentRepository departmentRepository,
			Educat_LevelRepository educat_LevelRepository) {
		this.studentRepository = studentRepository;
		this.departmentRepository = departmentRepository;
		this.educat_LevelRepository = educat_LevelRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// บันทึก Department และ Educat_level ก่อน
		Department department1 = new Department("Information Technology");
		Educat_level educat_level1 = new Educat_level("ปวส.2", department1);

		departmentRepository.save(department1);
		educat_LevelRepository.save(educat_level1);

		// ใช้ id ที่ได้จากการบันทึกมาในการสร้าง Student
		Student student = new Student("Narongsak", "Pumpasert", "65309001004", department1, educat_level1);
		studentRepository.save(student);
	}
}
