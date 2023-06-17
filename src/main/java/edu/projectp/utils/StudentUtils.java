package edu.projectp.utils;

import edu.projectp.models.dtos.CreateStudentDTO;
import edu.projectp.models.dtos.StudentDTO;
import edu.projectp.models.entities.Student;

public class StudentUtils {

    public static StudentDTO studentToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setAge(student.getAge());
        return studentDTO;
    }

    public static Student studentDtoToStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return student;
    }

    public static Student createStudentDtoToStudent(CreateStudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return student;
    }
}
