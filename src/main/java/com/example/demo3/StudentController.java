package com.example.demo3;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @GetMapping("/filter/course")
    public List<Student> filterByCourse(@RequestParam int course) {
        return service.filterByCourse(course);
    }

    @GetMapping("/filter/grade")
    public List<Student> filterByGrade(@RequestParam double grade) {
        return service.filterByGrade(grade);
    }

    @GetMapping("/filter/name")
    public List<Student> filterByName(@RequestParam String name) {
        return service.filterByName(name);
    }

    @GetMapping("/filter/birthdate")
    public List<Student> filterByBirthDate(
            @RequestParam String direction,
            @RequestParam String date
    ) {
        LocalDate parsedDate = LocalDate.parse(date);
        return direction.equalsIgnoreCase("before") ?
                service.filterByDateBefore(parsedDate) :
                service.filterByDateAfter(parsedDate);
    }

    @GetMapping("/paginated")
    public Page<Student> getStudentsPaginated(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false, defaultValue = "id") String sortBy
    ) {
        return service.getStudentsPaginated(page, size, sortBy);
    }

    @GetMapping("/group-by-course")
    public Map<Integer, List<Student>> groupByCourse() {
        return service.groupStudentsByCourse();
    }

}
