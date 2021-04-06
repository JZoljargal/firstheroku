package com.school.departmentservice.controller;

import java.util.List;

import com.school.departmentservice.model.Teacher;
import com.school.departmentservice.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher Teacher) throws Exception {
        return new ResponseEntity<>(teacherService.addTeacher(Teacher), HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Teacher>> getTeachers() {
        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") long id) throws Exception {
        Teacher Teacher = teacherService.findById(id);
        return new ResponseEntity<>(Teacher, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher Teacher) {
        Teacher updateTeacher = teacherService.updateTeacher(Teacher);
        return new ResponseEntity<>(updateTeacher, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
