package interview.student.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "student_subjects")
@Getter
@Setter
@Builder
public class StudentSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference("student-subject")
    @ToString.Exclude
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonManagedReference("subject-detail")
    @ToString.Exclude
    private Subject subject;
}
