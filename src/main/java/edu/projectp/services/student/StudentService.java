package edu.projectp.services.student;

import edu.projectp.models.dtos.CreateStudentDTO;
import edu.projectp.models.dtos.StudentDTO;
import edu.projectp.models.dtos.UpdateStudentDTO;
import edu.projectp.models.entities.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();
    StudentDTO findById(Integer id);
    StudentDTO create(CreateStudentDTO student);
    StudentDTO update(Integer id, UpdateStudentDTO student);
    void deleteById(Integer id);
}
