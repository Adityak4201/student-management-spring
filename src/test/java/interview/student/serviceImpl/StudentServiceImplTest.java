package interview.student.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import interview.student.models.Student;
import interview.student.repositories.StudentRepository;
import interview.student.testUtils.TestDataFactory;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void shouldReturnStudentWithSubjects() throws Exception {
        Iterable<Student> testStudents = TestDataFactory.createStudentWithSubjects();

        when(studentRepository.findAll()).thenReturn(testStudents);

        // Save student and cascade saves subjects
        Iterable<Student> students = studentRepository.findAll();

        List<Student> studentList = new ArrayList<>();
        students.iterator().forEachRemaining(studentList::add);

        assertEquals(2, studentList.size());

        Student studentDTO = studentList.get(0);
        assertEquals("test1", studentDTO.getName());
        assertEquals(2, studentDTO.getStudentSubjects().size());
    }

    @Test
    public void shouldSaveStudent() {
        Student studentDto = TestDataFactory.getStudent();

        when(studentRepository.save(any(Student.class))).thenReturn(studentDto);
        Student savedStudent = studentRepository.save(studentDto);

        assertEquals("test1", savedStudent.getName());
        verify(studentRepository).save(studentDto);
    }

    @Test
    public void shouldUpdateStudent() {
        Student studentDto = TestDataFactory.getStudent();
        studentDto.setAge(22);
        studentDto.setName("test2");
        studentDto.setRollNo("CS384");

        when(studentRepository.save(any(Student.class))).thenReturn(studentDto);
        Student savedStudent = studentRepository.save(studentDto);

        assertEquals("test2", savedStudent.getName());
        assertEquals("CS384", savedStudent.getRollNo());
        assertEquals(22, savedStudent.getAge());

        verify(studentRepository).save(studentDto);
    }

}
