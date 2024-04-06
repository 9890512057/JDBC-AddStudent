package com.tca.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDStudent {

	public static void main(String[] args) {
		  System.out.println("Enter a choice (1-4):");
		  System.err.println("Choose the following"+"\t\n"+"1. Add "+"\t\n"+"2. Delete"+"\t\n"+"3. show ");
		  
		  Scanner sc=new Scanner(System.in);
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1:
	                add();
	                break;
	            case 2:
	            	Delete();
	            	break;
	            case 3:
	            	show();
	            	break;
default:
	throw new IllegalArgumentException("Unexpected value: " + choice);
}
		
	}
	public static void Delete() {
		System.out.println("enter rno u want to delete");
		Scanner sc = new Scanner(System.in);
int rno=sc.nextInt();
		Connection con = null;
		PreparedStatement ps = null;
ResultSet rs=null;
		String url = "jdbc:postgresql://localhost/ab";
		String user = "root";
		String pass = "Abhinav@9696";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement("delete from stud where rno=?");
			ps.setInt(1, rno);
			int a=ps.executeUpdate();
			
			System.out.println("sucessfully deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void add() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;

		String url = "jdbc:postgresql://localhost/ab";
		String user = "root";
		String pass = "Abhinav@9696";
		System.out.println("enter Roll no of Student");
		int rno = sc.nextInt();
		System.out.println("Enter Name of Studnet:");
		String sname = sc.next();
		System.out.println("Enter percentages of Student:");
		float per = sc.nextFloat();

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement("insert into stud values(?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2, sname);
			ps.setFloat(3, per);
			int a = ps.executeUpdate();
			if (a == 1) {
				System.out.println("Studemt rno\t" + rno + "    Sueessfully");
			}
			System.err.println("***************************************************************************");

//			System.out.println("database Stud Contains Following Data");
//			Statement st = null;
//			st = con.createStatement();
//			String query = "select * from stud";
//
//			ResultSet rs = null;
//			rs = st.executeQuery(query);
//			while (rs.next()) {
//				System.out.print(rs.getInt(1) + "\t");
//				System.out.print(rs.getString(2) + "\t");
//				System.out.println(rs.getFloat(3) + "\t\n");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void show() {
		
		
		
		Connection con = null;
		Statement st = null;
		String url = "jdbc:postgresql://localhost/ab";
		String user = "root";
		String pass = "Abhinav@9696";
		
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			st = con.createStatement();
			String query = "select * from stud";
			
			rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getFloat(3) + "\t\n");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}


