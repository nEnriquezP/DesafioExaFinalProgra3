package edu.projectp.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateStudentDTO {
    @NotNull(message = "El Nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @NotNull(message = "La edad no puede ser nula")
    @Min(value = 19,message = "La edad debe de ser mayor a 18")
    private Integer age;
}
