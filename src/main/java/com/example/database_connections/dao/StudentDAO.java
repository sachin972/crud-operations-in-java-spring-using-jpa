package com.example.database_connections.dao;

import java.util.List;

import com.example.database_connections.entity.Student;

public interface StudentDAO {
    void save(Student newStudent);

    Student finByID(Integer id);

    List<Student> finaAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
