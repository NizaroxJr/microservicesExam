package com.nizarhl.courses.proxy;

import com.nizarhl.courses.model.Course;
import com.nizarhl.students.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "courses-service", url = "http://localhost:8082") // URL of courses service
public interface CoursesFeignClient {
    @GetMapping("/api/courses/{courseId}")
    Course getCourseById(@PathVariable("courseId") Long courseId);

    @GetMapping("/api/courses/{courseId}/students")
    List<Student> getStudentsInCourse(@PathVariable("courseId") Long courseId);
}