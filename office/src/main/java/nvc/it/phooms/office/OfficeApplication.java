package nvc.it.phooms.office;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nvc.it.phooms.office.model.Department;
import nvc.it.phooms.office.model.Employee;
import nvc.it.phooms.office.model.Project;
import nvc.it.phooms.office.repository.DepartmentRepository;
import nvc.it.phooms.office.repository.EmployeeRepository;
import nvc.it.phooms.office.repository.ProjectRepository;

@SpringBootApplication
public class OfficeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(OfficeApplication.class);

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ProjectRepository projectRepository;

	public OfficeApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
			ProjectRepository projectRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.projectRepository = projectRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Department department1 = new Department("Information Technology");
		Department department2 = new Department("Electric Engineering");
		Project project1 = new Project("Develop System Order Cake");
		Project project2 = new Project("Develop Electric");

		departmentRepository.saveAll(Arrays.asList(department1, department2));
		projectRepository.saveAll(Arrays.asList(project1, project2));

		employeeRepository.save(new Employee(30000, "Adam Samit", department1, project1));
		employeeRepository.save(new Employee(200000, "Adam Kolost", department1, project1));
		employeeRepository.save(new Employee(20000, "Jim Samit", department1, project1));
		employeeRepository.save(new Employee(15000, "Jame Doot", department2, project2));
		employeeRepository.save(new Employee(10000, "Jame Leed", department2, project2));
		employeeRepository.save(new Employee(5000, "Jame Kov", department2, project2));

		logger.info("\n-------------------------------------------------");
		for (Employee employee : employeeRepository.findAll()) {
			logger.info("\nname: {}, salary: {}, department: {} ", employee.getName(), employee.getSalary(),
					employee.getDepartment().getName());
		}
		logger.info("\n-------------------------------------------------");
		for (Employee employee : employeeRepository.findByName("Jame Kov")) {
			logger.info("\nname: {}, salary: {}, department: {} ", employee.getName(), employee.getSalary(),
					employee.getDepartment().getName());
		}
		logger.info("\n-------------------------------------------------");
		for (Employee employee : employeeRepository.findBySalaryGreaterThan(15000)) {
			logger.info("\nname: {}, salary: {}, department: {} ", employee.getName(), employee.getSalary(),
					employee.getDepartment().getName());
		}

		// for (Department department : departmentRepository.findAll()) {
		// logger.info("name: {}", department.getName());
		// }
		logger.info("-------------------------------------------------");
		for (Project project : projectRepository.findByNameContaining("k")) {
			logger.info("name:{}", project.getName());
		}
		logger.info("-------------------------------------------------");
		for (Project project : projectRepository.findByNameContaining("")) {
			logger.info("name:{}", project.getName());
		}
	}
}
