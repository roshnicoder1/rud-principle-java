package com.ibm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ibm.exception.DeptException;
import com.ibm.model.Dept;

public class DeptDAO {

	private Connection createConnection() throws SQLException, ClassNotFoundException
	{
	  String url="jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&requireSSL=false";
	  String username="root";
	  String password="root";
	  Class.forName("com.mysql.cj.jdbc.Driver");
	   return DriverManager.getConnection(url,username,password);
	}


	public boolean insertDept(Dept d) throws DeptException, ClassNotFoundException {
		boolean flag = false;
		try
		{
			Connection con = createConnection();
			String queryString = "insert into dept values (?,?,?)";
			
			PreparedStatement prepStatement = con.prepareStatement(queryString);
			prepStatement.setInt(1, d.getDeptno());
			prepStatement.setString(2, d.getDname());
			prepStatement.setString(3, d.getLoc());
				
			if(prepStatement.executeUpdate()>0)
			{
			
				flag = true;
			}
		}
		catch(SQLException e){
		}
		return flag;
	}
}

