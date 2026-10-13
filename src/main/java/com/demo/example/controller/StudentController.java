package com.demo.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.model.Student;
import com.demo.example.service.StudentService; 

@RequestMapping("/api/student")
@RestController
public class StudentController {
	
	 private final StudentService studentServiceImpl;
	 public StudentController(StudentService studentServiceImpl)
	 {
		 this.studentServiceImpl=studentServiceImpl;
	 }
    
	 @PostMapping
	 public ResponseEntity<Student> save(@RequestBody Student student)
	 {
		 Student student1=studentServiceImpl.save(student);
		 return new ResponseEntity<>(student1,HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Student> findById(@PathVariable("id") int id)
	 {
		 Student student=studentServiceImpl.findById(id);
		 if(student==null)
		 {
			 return ResponseEntity.notFound().build();
		 }
		 else
		 {
			 return ResponseEntity.ok(student); 
		 }
	 }
	 @GetMapping
	 public ResponseEntity<List<Student>> findAll()
	 {
		 List<Student>list=studentServiceImpl.findAll();
		 return ResponseEntity.ok(list);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> delete(@PathVariable("id") int id)
	 {
		 int rowAffected=studentServiceImpl.delete(id);
		 if(rowAffected!=0)
		 {
			 return ResponseEntity.ok("successfully deleted !...");
		 }
		 else
		 {
			 return ResponseEntity.notFound().build();
		 }
	 }
	 @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student)
    {
    	
		 Student student1=studentServiceImpl.update(student);
		 if(student1!=null)
		 {
			 return ResponseEntity.ok(student1);
		 }
		 else
		 {
			 return ResponseEntity.notFound().build();
		 }
    }
	 
}
