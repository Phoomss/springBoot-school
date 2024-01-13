package test.restapi.phooms.resapi.model;

import jakarta.persistence.Entity;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name, surname, idcard;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne()
    @JoinColumn(name = "educat_level_id")
    private Educat_level educat_level;

    public Student(String name, String surname, String idcard, Department department, Educat_level educat_level) {
        this.name = name;
        this.surname = surname;
        this.idcard = idcard;
        this.department = department;
        this.educat_level = educat_level;
    }
}
