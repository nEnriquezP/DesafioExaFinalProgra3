package edu.projectp.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CreateGradeDTO {
    @NotNull(message = "El ID del Estudiante no puede ser nulo")
    private Integer studentId;
    @NotNull(message = "El Curso no puede ser nulo")
    private Integer courseId;
    @NotNull(message = "El Total no puede ser nulo")
    @Max(value = 100, message = "El total de la Calificación no puede ser mayor a 100")
    @Min(value = 0, message = "El Total de la Calificación no puede ser menor a 0")
    private Integer total;
}
