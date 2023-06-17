package edu.projectp.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CreateGradeDTO {
    @NotNull(message = "Student id cannot be null")
    private Integer studentId;
    @NotNull(message = "Course id cannot be null")
    private Integer courseId;
    @NotNull(message = "Total cannot be null")
    @Max(value = 100, message = "Total cannot be greater than 100")
    @Min(value = 0, message = "Total cannot be less than 0")
    private Integer total;
}
