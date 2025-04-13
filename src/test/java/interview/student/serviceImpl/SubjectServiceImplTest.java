package interview.student.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import interview.student.repositories.StudentSubjectRepository;
import interview.student.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceImplTest {

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private StudentSubjectRepository studentSubjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Test
    public void shouldDeleteSubjectWhenUnassigned() {
        Integer subjectId = 101;

        when(studentSubjectRepository.countBySubjectId(subjectId)).thenReturn(0L);
        when(subjectRepository.existsById(subjectId)).thenReturn(true);

        try {
            subjectService.deleteSubject(subjectId.toString());
            verify(subjectRepository).deleteById(subjectId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void shouldThrowExceptionIfSubjectIsAssigned() {
        Integer subjectId = 101;

        when(studentSubjectRepository.countBySubjectId(subjectId)).thenReturn(3L);

        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> subjectService.deleteSubject(subjectId.toString()));

        assertEquals("Subject has already been assigned to students", ex.getMessage());

        verify(subjectRepository, never()).deleteById(any());
    }

    @Test
    public void shouldThrowExceptionIfSubjectNotFound() {
        Integer subjectId = 101;

        when(studentSubjectRepository.countBySubjectId(subjectId)).thenReturn(0L);
        when(subjectRepository.existsById(subjectId)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> subjectService.deleteSubject(subjectId.toString()));

        verify(subjectRepository, never()).deleteById(any());
    }

}
