package edu.projectp.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCourseDTO {
    @NotNull(message = "El nombre del Curso no puede ser nulo")
    @NotBlank(message = "El nomnbre del Curso no puede estar en blanco")
    private String name;
}
