package edu.projectp.utils;

import edu.projectp.models.dtos.GradeDTO;
import edu.projectp.models.entities.Grade;

public class GradeUtils {

    public static GradeDTO gradeToGradeDTO(Grade grade){
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setStudentId(grade.getStudent().getId());
        gradeDTO.setStudentName(grade.getStudent().getName());
        gradeDTO.setCourseId(grade.getCourse().getId());
        gradeDTO.setCourseName(grade.getCourse().getName());
        gradeDTO.setCreatedAt(grade.getCreatedAt());
        gradeDTO.setTotal(grade.getTotal());
        return gradeDTO;
    }
}
