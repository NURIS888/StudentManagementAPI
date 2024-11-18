package com.example.demo3;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        Student existing = getStudentById(id);
        existing.setName(student.getName());
        existing.setCourse(student.getCourse());
        existing.setGrade(student.getGrade());
        return repository.save(existing);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public List<Student> filterByCourse(int course) {
        return repository.findByCourse(course);
    }

    public List<Student> filterByGrade(double grade) {
        return repository.findByGradeGreaterThanEqual(grade);
    }

    public List<Student> filterByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> filterByDateBefore(LocalDate date) {
        return repository.findByDateOfBirthBefore(date);
    }

    public List<Student> filterByDateAfter(LocalDate date) {
        return repository.findByDateOfBirthAfter(date);
    }

    public Page<Student> getStudentsPaginated(int page, int size, String sortBy) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public Map<Integer, List<Student>> groupStudentsByCourse() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(Student::getCourse));
    }

}

