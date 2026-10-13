package com.demo.example.dao;

import java.util.List;

import com.demo.example.model.Student;

public interface StudentDao {
	public Student save(Student student);
	public Student findById(int id);
	public Student update(Student student);
	public int delete(int id);
	public List<Student>findAll();

}
