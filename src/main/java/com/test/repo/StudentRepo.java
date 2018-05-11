package com.test.repo;

import com.test.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNo(Long rollNo);
    List<Student> findAll();
}
