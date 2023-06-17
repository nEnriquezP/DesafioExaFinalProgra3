package edu.projectp.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateGradeDTO {
    @NotNull(message = "El Total de la Calificación no puede ser nulo")
    @Max(value = 100, message = "El Total de la Calificación no puede ser mayor a 100")
    @Min(value = 0, message = "El Total de la Calificación no puede ser menor a 0")
    private Integer total;
}
