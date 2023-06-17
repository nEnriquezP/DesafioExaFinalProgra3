package edu.projectp.controllers;

import edu.projectp.models.dtos.*;
import edu.projectp.models.entities.Grade;
import edu.projectp.services.course.CourseService;
import edu.projectp.services.grade.GradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {
//
    @Autowired
    private GradeService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GradeDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public GradeDTO findById(@PathVariable Integer studentId, @PathVariable Integer courseId){
        return service.findById(studentId, courseId);
    }
//
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateGradeDTO grade){
        service.create(grade);
    }
//
    @PutMapping("/student/{studentId}/course/{courseId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer studentId, @PathVariable Integer courseId, @Valid @RequestBody  UpdateGradeDTO gradeDTO){
        service.update(studentId, courseId, gradeDTO);
    }
//
    @DeleteMapping("/student/{studentId}/course/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer studentId, @PathVariable Integer courseId){
        service.deleteById(studentId, courseId);
    }
}
