package com.tca.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowStudent {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs=null;
		String url = "jdbc:postgresql://localhost/ab";
		String user = "root";
		String pass = "Abhinav@9696";
		String query="select * from Stud";
		try {

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			st=con.createStatement();
			// st.execute(query);
			 rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getFloat(3)+"\t\n");
				System.out.println("Done");
				System.out.println("Done");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
