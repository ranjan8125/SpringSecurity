package com.example.demo.students;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	private final List<Student> Students = Arrays.asList(
			new Student(1,"Amigo"),
			new Student(2,"code"),
			new Student(3,"youtube"));

	@GetMapping(path = "{studentId}")
	public Student findStudentById(@PathVariable("studentId") Integer studentId) {
		return Students
				.stream()
				.filter(student -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));

	}
	
	

}
