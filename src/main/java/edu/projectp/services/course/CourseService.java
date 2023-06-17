package edu.projectp.services.course;

import edu.projectp.models.dtos.*;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();
    CourseDTO findById(Integer id);
    CourseDTO create(CreateCourseDTO courseDTO);
    CourseDTO update(Integer id, UpdateCourseDTO courseDTO);
    void deleteById(Integer id);
}
