package edu.projectp.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCourseDTO {
    @NotNull(message = "El nombre del curso no puede ser nulo")
    @NotBlank(message = "NEl nombre del Curso no puede estar en Blanco")
    private String name;
}
