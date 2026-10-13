package com.demo.example.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.example.dao.StudentDao;
import com.demo.example.model.Student;
import com.demo.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentDao studentDaoImpl;
     public StudentServiceImpl(StudentDao studentDaoImpl)
	{
		this.studentDaoImpl=studentDaoImpl;
	}
	@Override
	public Student save(Student student) {
		return studentDaoImpl.save(student);
	}

	@Override
	public Student findById(int id) {
		return studentDaoImpl.findById(id);
	}

	@Override
	public Student update(Student student) {
		return studentDaoImpl.update(student);
	}

	@Override
	public int delete(int id) { 
		return studentDaoImpl.delete(id);
	}

	@Override
	public List<Student> findAll() { 
		return studentDaoImpl.findAll();
	}

}
