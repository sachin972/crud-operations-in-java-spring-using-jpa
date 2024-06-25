package com.example.database_connections.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.database_connections.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImplementation implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student newStudent) {
        entityManager.persist(newStudent);
    }

    @Override
    public Student finByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> finaAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student order by lastName asc", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:lastName", Student.class);

        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

}
