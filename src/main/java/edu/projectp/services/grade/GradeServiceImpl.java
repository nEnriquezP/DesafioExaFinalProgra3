package edu.projectp.services.grade;

import edu.projectp.exceptions.NotFoundException;
import edu.projectp.models.dtos.*;
import edu.projectp.models.entities.Grade;
import edu.projectp.models.entities.GradeId;
import edu.projectp.repositories.grade.GradeRepository;
import edu.projectp.services.course.CourseService;
import edu.projectp.services.student.StudentService;
import edu.projectp.utils.GradeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static edu.projectp.utils.CourseUtils.courseDtoToCourse;
import static edu.projectp.utils.GradeUtils.gradeToGradeDTO;
import static edu.projectp.utils.StudentUtils.studentDtoToStudent;

@Service
public class GradeServiceImpl implements GradeService{

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @Override
    public List<GradeDTO> findAll() {
        return gradeRepository.findAll().stream().map(GradeUtils::gradeToGradeDTO).toList();
    }

    @Override
    public GradeDTO findById(Integer studentId, Integer courseId) {
        Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new NotFoundException(String.format("Grade with student id %d and course id %d not found", studentId, courseId)));
        return gradeToGradeDTO(grade);
    }

    @Override
    @Transactional
    public void create(CreateGradeDTO gradeDTO) {
        StudentDTO studentDTO = studentService.findById(gradeDTO.getStudentId());
        CourseDTO courseDTO = courseService.findById(gradeDTO.getCourseId());
        Grade grade = new Grade();
        grade.setStudent(studentDtoToStudent(studentDTO));
        grade.setCourse(courseDtoToCourse(courseDTO));
        grade.setTotal(gradeDTO.getTotal());
        grade.setCreatedAt(LocalDate.now());
        gradeRepository.save(grade);
    }

    @Override
    @Transactional
    public void update(Integer studentId, Integer courseId, UpdateGradeDTO gradeDTO) {
        GradeDTO foundGradeDTO = findById(studentId, courseId);
        gradeRepository.updateTotalByStudentIdAndCourseId(foundGradeDTO.getStudentId(), foundGradeDTO.getCourseId() , gradeDTO.getTotal());
    }

    @Transactional
    @Override
    public void deleteById(Integer studentId, Integer courseId) {
        GradeDTO gradeDTO = findById(studentId, courseId);
        gradeRepository.deleteByStudentIdAndCourseId(gradeDTO.getStudentId(), gradeDTO.getCourseId());
    }

}
