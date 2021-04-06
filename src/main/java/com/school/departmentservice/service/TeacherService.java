package com.school.departmentservice.service;

import java.util.List;

import com.school.departmentservice.model.Teacher;
import com.school.departmentservice.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    public Teacher addTeacher(Teacher teacher) {
        log.info("ADD TEACHER==>>" + teacher);
        return teacherRepo.save(teacher);
    }

    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    public Teacher findById(long id) throws Exception {
        return teacherRepo.findById(id).orElseThrow(() -> new Exception("Teacher by id " + id + " was not found"));
    }

    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public void deleteTeacher(long id) {
        teacherRepo.deleteById(id);
    }
}
