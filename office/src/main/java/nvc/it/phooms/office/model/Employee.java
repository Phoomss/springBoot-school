package nvc.it.phooms.office.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int salary;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne()
    @JoinColumn(name = "project_id")
    private Project project;

    public Employee(int salary, String name, Department department, Project project) {
        this.salary = salary;
        this.name = name;
        this.department = department;
        this.project = project;
    }
}
