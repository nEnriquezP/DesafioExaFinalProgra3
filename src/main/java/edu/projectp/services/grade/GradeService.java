package edu.projectp.services.grade;

import edu.projectp.models.dtos.*;
import edu.projectp.models.entities.Grade;

import java.util.List;

public interface GradeService {
    List<GradeDTO> findAll();
    GradeDTO findById(Integer studentId, Integer courseId);
    void create(CreateGradeDTO gradeDTO);
    void update(Integer studentId, Integer courseId, UpdateGradeDTO gradeDTO);
    void deleteById(Integer studentId, Integer courseId);
}
