package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.student.model.Student;

public class DAOImpl implements DAOInterface{
	Connection con=null;
	public DAOImpl(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		} catch (ClassNotFoundException e) {
        	System.out.println("ClassNotFoundException : "+e.getMessage());
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	} catch(Exception e) {
            System.out.println(e);
        }
	}
	
	public boolean addStudent(Student std) {
	   boolean b = false;
       try {
	       PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?,?,?)");
	       pstmt.setInt(1, std.getId());
	       pstmt.setString(2, std.getName());
	       pstmt.setInt(3, std.getMarks());
	       pstmt.setString(4, std.getCity());
	       
	       int i = pstmt.executeUpdate();
	       if(i>0) {
	           b=true;
	       }
       }
       catch(Exception e) {
           System.out.println(e);
       }
        return b;
	}
	
	public List<Student> viewAllStudents(){
		List<Student> allStudents = new ArrayList<Student>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from student");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				int marks = rs.getInt("marks");
				
				Student st = new Student(id, marks, name, city);
				allStudents.add(st);
			}
		}catch(Exception e) {
	           System.out.println(e);
	    }
		return allStudents;
	}
	
	public boolean deleteStudent(int sid) {
		boolean b = false;
	       try {
	    	   PreparedStatement pstmt = con.prepareStatement("delete from student where id = " + sid);
	    	   int i = pstmt.executeUpdate();
		       if(i>0) {
		           b=true;
		       }
	       }catch(Exception e) {
	           System.out.println(e);
	       }
	    return b;
	}
	
	public boolean updateStudent(Student std) {
		boolean b = false;
	       try {
	    	   PreparedStatement pstmt = con.prepareStatement(
	    			   "update student set name = '" + std.getName() +
	    			   	"', marks = " + std.getMarks() + ", city = '" + std.getCity()
	    			   	+ "' where id = " + std.getId());
	    	   int i = pstmt.executeUpdate();
		       if(i>0) {
		           b=true;
		       }
	       }catch(Exception e) {
	           System.out.println(e);
	       }
	    return b;
	}
}
