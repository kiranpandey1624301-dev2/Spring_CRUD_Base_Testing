package com.demo.example.daoImpl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.example.dao.StudentDao;
import com.demo.example.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {

	 private final JdbcTemplate jdbcTemplate ;
	 
	 public StudentDaoImpl(JdbcTemplate jdbcTemplate)
	 {
		 this.jdbcTemplate=jdbcTemplate;
	 }
	@Override
	public Student save(Student student) {
	 
		String query="insert into insmarks(uroll,uname,uphy,uche,umaths)values(?,?,?,?,?)";
		Object data[]= {student.getId(),student.getUname(),student.getUphy(),student.getUche(),student.getUmaths()};
		
		int rowAffected=jdbcTemplate.update(query,data);
		if(rowAffected!=0)
		{
			return student;
		}
		
		return null;
	}

	@Override
	public Student findById(int id) {
	 
		String query="select * from insmarks where uroll=?";
		List<Student> list=jdbcTemplate.query(query,(rs,i)->{
			Student student=new Student();
			student.setId(rs.getInt(1));
			student.setUname(rs.getString(2));
			student.setUphy(rs.getString(3));
			student.setUche(rs.getString(4));
			student.setUmaths(rs.getString(5));
			return student;
		},id);
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
		return list.get(0);
		}
	}

	@Override
	public Student update(Student student) {
	 
		String query="update insmarks set uname=?,uphy=?,uche=?,umaths=? where uroll=?";
		Object data[]= {student.getUname(),student.getUphy(),student.getUche(), student.getUmaths(),student.getId()};
		int rowAffected=jdbcTemplate.update(query,data);
		if(rowAffected>0)
		{
			return student;
		}
		return null;
	}

	@Override
	public int delete(int id) {

   String query="delete from insmarks where uroll=?";
      int rowAffected=jdbcTemplate.update(query,id);
		return rowAffected;
	}

	@Override
	public List<Student> findAll() {
		 
		String query="select * from insmarks";
		List<Student>list=jdbcTemplate.query(query,(rs,i)->{
			Student student=new Student();
			student.setId(rs.getInt(1));
			student.setUname(rs.getString(2));
			student.setUphy(rs.getString(3));
			student.setUche(rs.getString(4));
			student.setUmaths(rs.getString(5));
          
			return student;
		});
		return list; 
	}

}
