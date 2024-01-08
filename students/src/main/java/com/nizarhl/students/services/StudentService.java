package com.nizarhl.students.services;

import com.nizarhl.students.model.Student;
import com.nizarhl.students.proxy.CoursesFeignClient;
import com.nizarhl.students.proxy.StudentsFeignClient;
import com.nizarhl.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentsFeignClient studentsFeignClient;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            // Update other properties as needed
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Course> getCoursesForStudent(Long studentId) {
        return studentsFeignClient.getCoursesForStudent(studentId);
    }


}

