package edu.projectp.services.course;

import edu.projectp.exceptions.AlreadyExistsException;
import edu.projectp.exceptions.NotFoundException;
import edu.projectp.models.dtos.*;
import edu.projectp.models.entities.Course;
import edu.projectp.models.entities.Student;
import edu.projectp.repositories.course.CourseRepository;
import edu.projectp.repositories.student.StudentRepository;
import edu.projectp.services.student.StudentService;
import edu.projectp.utils.CourseUtils;
import edu.projectp.utils.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static edu.projectp.utils.CourseUtils.*;
import static edu.projectp.utils.StudentUtils.*;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public List<CourseDTO> findAll() {
        return repository.findAll()
                        .stream()
                        .map(CourseUtils::courseToCourseDTO).toList();
    }

    @Override
    public CourseDTO findById(Integer id) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Course with id %d not found", id)));
        return courseToCourseDTO(course);
    }

    @Override
    public CourseDTO create(CreateCourseDTO courseDTO) {
        Course course = createCourseDtoToCourse(courseDTO);
        Course createdCourse = repository.save(course);
        return courseToCourseDTO(createdCourse);
    }

    @Override
    public CourseDTO update(Integer id, UpdateCourseDTO courseDTO) {
        CourseDTO foundCourse = findById(id);
        foundCourse.setName(courseDTO.getName());
        Course updatedCourse = repository.save(courseDtoToCourse(foundCourse));
        return courseToCourseDTO(updatedCourse);
    }

    @Override
    public void deleteById(Integer id) {
        CourseDTO foundCourseDTO = findById(id);
        repository.deleteById(foundCourseDTO.getId());
    }
}
