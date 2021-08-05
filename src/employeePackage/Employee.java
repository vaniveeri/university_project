package employeePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.Scanner;

import util.DBconnection;
import utilities.Address;
import utilities.education;
import utilities.Experience;

public class Employee {
		public int employee_id,address_id,education_id,exp_id;
		public String name;
		public double salary;
		public String department;
		public  int dojYear;
		public String dob;
		public String designation;

		
		public Address empAddress=new Address();

	    Experience empExperience=new Experience();
		education empEducation=new education();
		
		Connection con = DBconnection.getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		
		public int getEmployee_id() {
			return employee_id;
		}
		public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
		}
		public int getAddress_id() {
			return address_id;
		}
		public void setAddress_id(int address_id) {
			this.address_id = address_id;
		}
		public int getEducation_id() {
			return education_id;
		}
		public void setEducation_id(int education_id) {
			this.education_id = education_id;
		}
		public int getExp_id() {
			return exp_id;
		}
		public void setExp_id(int exp_id) {
			this.exp_id = exp_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public int getDojYear() {
			return dojYear;
		}
		public void setDojYear(int dojYear) {
			this.dojYear = dojYear;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		
		public Address getEmpAddress() {
			return empAddress;
		}
		public void setEmpAddress(Address empAddress) {
			this.empAddress = empAddress;
		}
		public Experience getEmpExperience() {
			return empExperience;
		}
		public void setEmpExperience(Experience empExperience) {
			this.empExperience = empExperience;
		}
		public education getEmpEducation() {
			return empEducation;
		}
		public void setEmpEducation(education empEducation) {
			this.empEducation = empEducation;
		}
		public void setEmployeeDetails() {
			Scanner sc=new Scanner(System.in);
			Scanner sc1=new Scanner(System.in);
			System.out.println("Enter Employee ID");
			int id=sc.nextInt();
			System.out.println("Enter Employee Name");
			String name=sc1.nextLine();
			System.out.println("Enter Employee salary");
			int salary=sc.nextInt();
			System.out.println("Enter department");
			String department=sc1.nextLine();
			System.out.println("Enter date of joining year");
			String dojYear=sc1.nextLine();
			System.out.println("Enter dob");
			String dob=sc1.nextLine();
			System.out.println("Enter designation");
			String designation=sc1.nextLine();
			System.out.println("enter address id :");
			int address_id=sc.nextInt();
			System.out.println("enter education id :");
			int education_id=sc.nextInt();
			System.out.println("enter experience id :");
			int exp_id=sc.nextInt();
			
			System.out.println("Enter Employee Education details :");
			empEducation.setEducationDetails();
			  
			System.out.println("Enter Employee Address details :");
			empAddress.setAddress();
			 
			System.out.println("Enter Employee Experience details :");
			empExperience.setExperience();
			
			try {
			 stmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
			 stmt.setInt(1, id);
			 stmt.setString(2, name);
			 stmt.setDouble(3,salary);
			 stmt.setString(4,department);
			 stmt.setString(5, dojYear);
			 stmt.setString(6,dob);
			 stmt.setString(7,designation);
			 stmt.setInt(8,address_id);
			 stmt.setInt(9,education_id);
			 stmt.setInt(10,exp_id);
			 stmt.executeUpdate();
			 rs =stmt.executeQuery("select * from employee");
			 
		 System.out.println("Values Inserted successfully in employee");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public void getEmployeeDetails()
			{
	           System.out.println("Employee details are:");
	           System.out.println("Employee Education details :");
	      	   empEducation.getEducation();
	      	 
	           System.out.println("Employee Address Details :");
	           empAddress.getAddress();
	           
	           System.out.println();
	           
	           System.out.println("Employee experience Details :");
	           empExperience.getExperience();
	           
	           
		    try {
	
			String sql = "select * from employee";
			stmt = con.prepareStatement(sql);		
			rs = stmt.executeQuery(sql);

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
			           System.out.print(rs.getString(i) + "   ");
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
