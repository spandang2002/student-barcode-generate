package com.ilearn.chk.studentbarcode.repository;

import com.ilearn.chk.studentbarcode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

