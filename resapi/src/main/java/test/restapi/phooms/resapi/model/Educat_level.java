package test.restapi.phooms.resapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Educat_level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "deparment_id")
    private Department department;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educat_level")
    private List<Student> students;

    public Educat_level(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}
