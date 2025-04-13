package interview.student.testUtils;

import interview.student.dtos.request.CreateStudentRequestDto;
import interview.student.enums.Branch;
import interview.student.models.*;

import java.util.List;
import java.util.ArrayList;

public class TestDataFactory {

    public static Iterable<Student> createStudentWithSubjects() {
        Student student = new Student();
        student.setId(1);
        student.setName("test1");
        student.setAge(20);
        student.setRollNo("975");

        Student student2 = Student.builder().id(2).name("test2").age(22).rollNo("387").build();

        Subject math = createSubject(101, "Math", Branch.COMPUTER_SCIENCE);
        Subject physics = createSubject(102, "Physics", Branch.CIVIL);

        StudentSubject ss1 = new StudentSubject();
        ss1.setId(1);
        ss1.setStudent(student);
        ss1.setSubject(math);

        StudentSubject ss2 = new StudentSubject();
        ss2.setId(2);
        ss2.setStudent(student);
        ss2.setSubject(physics);

        StudentSubject ss3 = new StudentSubject();
        ss3.setId(3);
        ss3.setStudent(student2);
        ss3.setSubject(physics);

        List<StudentSubject> studentSubjects = new ArrayList<>();
        studentSubjects.add(ss1);
        studentSubjects.add(ss2);

        List<StudentSubject> studentSubjects2 = new ArrayList<>();
        studentSubjects2.add(ss3);

        student.setStudentSubjects(studentSubjects);
        student2.setStudentSubjects(studentSubjects2);

        math.setStudentSubjects(List.of(ss1));
        physics.setStudentSubjects(List.of(ss2, ss3));

        return List.of(student,student2);
    }

    public static Subject createSubject(Integer id, String name, Branch branch) {
        Subject subject = new Subject();
        subject.setId(id);
        subject.setName(name);
        subject.setBranch(branch);
        return subject;
    }

    public static List<Subject> getSampleSubjects() {
        return List.of(
                createSubject(101, "Math", Branch.COMPUTER_SCIENCE),
                createSubject(102, "Physics", Branch.CIVIL),
                createSubject(103, "Chemistry", Branch.MECHANICAL));
    }

    public static CreateStudentRequestDto getCreateStudentRequestDto() {
        return CreateStudentRequestDto.builder().name("test 1").age(22).rollNo("CS284").build();
    }

    public static Student getStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("test1");
        student.setAge(20);
        student.setRollNo("975");
        return student;
    }
}
