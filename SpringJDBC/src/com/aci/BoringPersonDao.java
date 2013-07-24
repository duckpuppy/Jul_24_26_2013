package com.aci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BoringPersonDao {
	public void insert(String name,int age)throws SQLException{
		Connection con = null;
		try {
			Class.forName("driver");
			con = DriverManager.getConnection("url");
			Statement stmt = con.createStatement();
			stmt.execute("query");
			stmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			con.close();
		}
	}
}
