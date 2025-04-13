package interview.student.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import interview.student.enums.Branch;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subjects")
@Getter
@Setter
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Branch branch;

    @OneToMany(mappedBy = "subject")
    @JsonBackReference("subject-detail")
    @ToString.Exclude
    private List<StudentSubject> studentSubjects;

}
