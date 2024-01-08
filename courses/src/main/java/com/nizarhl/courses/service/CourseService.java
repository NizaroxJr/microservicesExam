package com.nizarhl.courses.service;

import com.nizarhl.courses.model.Course;
import com.nizarhl.courses.proxy.CoursesFeignClient;
import com.nizarhl.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CoursesFeignClient coursesFeignClient;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setName(courseDetails.getName());
            course.setInstructor(courseDetails.getInstructor());
            // Update other properties as needed
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Student> getStudentsInCourse(Long courseId) {
        return coursesFeignClient.getStudentsInCourse(courseId);
    }

