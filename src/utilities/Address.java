package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import util.DBconnection;

public class Address {

	int address_id;
	String houseNo;
	String street,locality,area,state,country;
	int pin;
	

	
	
    public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	Connection con = DBconnection.getConnection();
	ResultSet rs=null;
	PreparedStatement stmt=null;
	public void setAddress()
    {
    	Scanner sc=new Scanner(System.in);
    	Scanner sc1=new Scanner(System.in);
    	System.out.println("enter address id:");
    	int address_id=sc1.nextInt();
    	System.out.println("enter houseno:");
    	String houseNo=sc.nextLine();
    	System.out.println("enter street:");
    	String street=sc.nextLine();
    	System.out.println("enter locality:");
    	String locality=sc.nextLine();
    	System.out.println("enter area:");
    	String area=sc.nextLine();
    	System.out.println("enter state:");
    	String state=sc.nextLine();
    	System.out.println("enter country:");
    	String country=sc.nextLine();
    	System.out.println("enter pin:");
    	int pin=sc1.nextInt();

		try {
		 stmt = con.prepareStatement("insert into address values(?,?,?,?,?,?,?,?)");
		 stmt.setInt(1, address_id);
		 stmt.setString(2, houseNo);
		 stmt.setString(3, street);
		 stmt.setString(4,locality);
		 stmt.setString(5,area);
		 stmt.setString(6, state);
		 stmt.setString(7,country);
		 stmt.setInt(8,pin);
		 stmt.executeUpdate();
		 rs =stmt.executeQuery("select * from address");
		 
	 System.out.println("Values Inserted successfully in address");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
    }
	
	public void getAddress()
	{
	
		try {
			
			String sql = "select * from address";
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
	



	