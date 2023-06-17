package edu.projectp.models.pojos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Message {
    private String subject;
    private String datetime;
}
