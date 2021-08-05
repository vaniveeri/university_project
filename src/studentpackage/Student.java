package studentpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBconnection;
import utilities.Address;
import utilities.education;

public class Student {
	public int sid,education_id,address_id;
	public String name;
	public String dob;
	public String college;
	public education studentEducation=new education();
	public Address studentAddress=new Address();
	
	Connection con = DBconnection.getConnection();
	ResultSet rs=null;
	PreparedStatement stmt=null;
	
	public int getSId() {
		return sid;
	}
	public void setSId(int SId) {
		this.sid = SId;
	}
	public int getEducation_id() {
		return education_id;
	}
	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public education getStudentEducation() {
		return studentEducation;
	}
	public void setStudentEducation(education studentEducation) {
		this.studentEducation = studentEducation;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public void setStudentDetails() {
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("enter student id :");
		int sid=sc.nextInt();
	    System.out.println("enter Student name :");
	    String name=sc1.nextLine();
		System.out.println("enter student date of birth :");
		String dob=sc1.nextLine();
		System.out.println("enter college name :");
	    String college=sc1.nextLine();
		System.out.println("enter address id :");
		int address_id=sc.nextInt();
		System.out.println("enter education id :");
		int education_id=sc.nextInt();
		
		System.out.println(" Enter Student Education details :");
	    studentEducation.setEducationDetails();
	    
	    System.out.println("Student Address Details :");
	    studentAddress.setAddress();
	
		try {
		 stmt = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
		 stmt.setInt(1, sid);
		 stmt.setString(2, name);
		 stmt.setString(3,dob);
		 stmt.setString(4, college);
		 stmt.setInt(5,address_id);
		 stmt.setInt(6, education_id);
		 

		 stmt.executeUpdate();
		 rs =stmt.executeQuery("select * from student");
		 
	 System.out.println("Values Inserted successfully in student");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void getStudentDetails() throws ClassNotFoundException
		{
		System.out.println("student details are:");
		System.out.println("Student Education details :");
		studentEducation.getEducation();
	    
	    System.out.println("Student Address Details :");
	    studentAddress.getAddress();
	    
	    try {
	    	Statement st=DBconnection.con.createStatement();
			String sql = "select * from student";
			st = con.prepareStatement(sql);		
			rs = st.executeQuery(sql);
		
			ResultSetMetaData resultSetMetaData = rs.getMetaData();

			   int columnCount = resultSetMetaData.getColumnCount();

			   // Print column info
			   for (int i = 1; i <= columnCount; i++) 
			   {
			       System.out.print(resultSetMetaData.getColumnName(i) + "   ");
			   }

			   System.out.println();

			   // Print row info
			   while (rs.next())
			   {
			       for (int i = 1; i <= columnCount; i++) 
			       {
			           System.out.print(rs.getString(i) + "    ");
			       }

			       System.out.println();

			   }
			  
				}
				catch(SQLException s)
				{
					System.out.println(s);
				}
				
				
			}  
	
	
	
}
