package com.example.demo3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourse(int course);
    List<Student> findByGradeGreaterThanEqual(double grade);
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByDateOfBirthBefore(LocalDate date);
    List<Student> findByDateOfBirthAfter(LocalDate date);

    Page<Student> findAll(Pageable pageable);
}


