package edu.projectp.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateGradeDTO {
    @NotNull(message = "Total cannot be null")
    @Max(value = 100, message = "Total cannot be greater than 100")
    @Min(value = 0, message = "Total cannot be less than 0")
    private Integer total;
}
