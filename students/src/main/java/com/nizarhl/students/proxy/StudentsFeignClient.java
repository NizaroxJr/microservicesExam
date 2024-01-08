package com.nizarhl.students.proxy;

import com.nizarhl.courses.model.Course;
import com.nizarhl.students.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "students-service", url = "http://localhost:8081") // URL of students service
public interface StudentsFeignClient {
    @GetMapping("/api/students/{studentId}")
    Student getStudentById(@PathVariable("studentId") Long studentId);

    @GetMapping("/api/students/{studentId}/courses")
    List<Course> getCoursesForStudent(@PathVariable("studentId") Long studentId);
}
