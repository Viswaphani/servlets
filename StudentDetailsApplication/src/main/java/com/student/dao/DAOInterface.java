package com.student.dao;

import java.util.List;
import com.student.model.Student;

public interface DAOInterface {
	public boolean addStudent(Student std);

    public boolean deleteStudent(int sid);

    public boolean updateStudent(Student std);

    //public Student getStudentById(int sid);

    public List<Student> viewAllStudents();
}
