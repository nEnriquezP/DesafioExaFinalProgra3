package edu.projectp.models.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
public class CourseDTO {
    @Id
    private Integer id;
    private String name;
}
