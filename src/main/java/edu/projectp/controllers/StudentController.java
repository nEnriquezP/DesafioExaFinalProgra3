package edu.projectp.controllers;

import edu.projectp.models.dtos.CreateStudentDTO;
import edu.projectp.models.dtos.StudentDTO;
import edu.projectp.models.dtos.UpdateStudentDTO;
import edu.projectp.services.student.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO create(@Valid @RequestBody CreateStudentDTO student){
        return service.create(student);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDTO update(@PathVariable Integer id, @Valid @RequestBody UpdateStudentDTO student){
        return service.update(id, student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
