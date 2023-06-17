package edu.projectp.services.student;

import edu.projectp.exceptions.AlreadyExistsException;
import edu.projectp.exceptions.NotFoundException;
import edu.projectp.models.dtos.CreateStudentDTO;
import edu.projectp.models.dtos.StudentDTO;
import edu.projectp.models.dtos.UpdateStudentDTO;
import edu.projectp.models.entities.Student;
import edu.projectp.repositories.student.StudentRepository;
import edu.projectp.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static edu.projectp.utils.StudentUtils.*;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public List<StudentDTO> findAll() {
        return repository.findAll()
                        .stream()
                        .map(StudentUtils::studentToStudentDTO).toList();
    }

    @Override
    public StudentDTO findById(Integer id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Student with id %d not found", id)));
        return studentToStudentDTO(student);
    }

    @Override
    public StudentDTO create(CreateStudentDTO studentDTO) {
        Student student = createStudentDtoToStudent(studentDTO);
        Student createdStudent = repository.save(student);
        return studentToStudentDTO(createdStudent);
    }

    @Override
    public StudentDTO update(Integer id, UpdateStudentDTO studentDTO) {
        StudentDTO foundStudent = findById(id);
        foundStudent.setName(studentDTO.getName());
        foundStudent.setAge(studentDTO.getAge());
        Student updatedStudent = repository.save(studentDtoToStudent(foundStudent));
        return studentToStudentDTO(updatedStudent);
    }

    @Override
    public void deleteById(Integer id) {
        StudentDTO foundStudentDTO = findById(id);
        repository.deleteById(foundStudentDTO.getId());
    }
}
