package edu.projectp.utils;

import edu.projectp.models.dtos.CourseDTO;
import edu.projectp.models.dtos.CreateCourseDTO;
import edu.projectp.models.entities.Course;

public class CourseUtils {

    public static CourseDTO courseToCourseDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        return courseDTO;
    }

    public static Course courseDtoToCourse(CourseDTO courseDTO){
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        return course;
    }

    public static Course createCourseDtoToCourse(CreateCourseDTO courseDTO){
        Course course = new Course();
        course.setName(courseDTO.getName());
        return course;
    }
}
