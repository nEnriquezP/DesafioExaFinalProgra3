package edu.projectp.models.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GradeDTO {
    private Integer studentId;
    private String studentName;
    private Integer courseId;
    private String courseName;
    private LocalDate createdAt;
    private Integer total;
}
