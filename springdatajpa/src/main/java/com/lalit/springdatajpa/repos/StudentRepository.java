package com.lalit.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalit.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
