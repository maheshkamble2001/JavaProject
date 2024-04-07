package com.utility;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.model.*;
public class StudentDao {
	
	public int addStudent(Student st)
	{
		int val=0;
		Connection con = DBUtility.DBConnectivity();
		String sql = "insert into student values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, st.getRollNo());
			ps.setString(2, st.getName());
			ps.setDouble(3, st.getMarks());
			val = ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception occured in add student :"+e);
		}
		return val;
	}
	public int updateStudent(Student st)
	{
		int val=0;
		Connection con = DBUtility.DBConnectivity();
		String sql = "update student set name=?,marks=? where rollNo=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, st.getRollNo());
			ps.setString(1, st.getName());
			ps.setDouble(2, st.getMarks());
			val = ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception occured in add student :"+e);
		}
		return val;
	}
	public int deleteStudent(Student st)
	{
		int val=0;
		Connection con = DBUtility.DBConnectivity();
		String sql = "delete from student where rollNo = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, st.getRollNo());
			val = ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Exception occured in add student :"+e);
		}
		return val;
	}
	
	public List<Student> getAllStudent()
	{
		List<Student>  list = new ArrayList<Student>();
		Connection con = DBUtility.DBConnectivity();
		String sql = "select * from student";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Student(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
		}catch(Exception e)
		{
			System.out.print("Exception occured in get all student "+e);
		}
		return list;
	}
}
