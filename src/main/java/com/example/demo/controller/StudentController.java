package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studRepo;

	@GetMapping("/")
	public List<Student> getStudent() {
		System.out.println("here!");
		return studRepo.findAll();
	}

	@GetMapping("/student/{studId}")
	public Optional<Student> getStudent(@PathVariable("studId") int studId) {
		return studRepo.findById(studId);
	}

	@GetMapping("/students/age/{age}")
	public List<Student> getStudentByAge(@PathVariable("age") int age) {
		return studRepo.findByAge(age);
	}

	@PostMapping(path = "students")
	public Student createStudent(@RequestBody Student studData) {
		Optional<Student> foundStudent = studRepo.findByFirstName(studData.getFirstName());
		if (foundStudent.isPresent()) {
			throw new IllegalArgumentException(
					"A student with the names " + studData.getFirstName() + "already exists");
		}
		return studRepo.save(studData);
	}

	@PutMapping(path="/student/{studId}")
	public Student updateStudent(@PathVariable("studId") int studId, @RequestBody Student stud) {
		Student foundStud = studRepo.findById(studId).orElseThrow(()-> new IllegalStateException("Student with ID" + studId + " is not found"));
		foundStud.setAge(stud.getAge());
		foundStud.setFirstName(stud.getFirstName());
		foundStud.setLastName(stud.getLastName());
		studRepo.save(foundStud);
		
		return foundStud;
	}
 
	@DeleteMapping(path = "/students/{studId}")
	public Student deleteStudent(@PathVariable("studId") int studId) {
		Student deletedStudent = studRepo.findById(studId)
				.orElseThrow(() -> new IllegalStateException("Student with Id " + studId + "is not found"));
		studRepo.deleteById(studId);
		return deletedStudent;
	}

}
