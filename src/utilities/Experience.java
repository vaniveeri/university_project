package utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBconnection;
public class Experience 
{
	public int id;
    public String organisationName;
	public String designation;
	public int exp;
	
	Connection con = DBconnection.getConnection();
	ResultSet rs=null;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExp() 
	{
		return exp;
	}

	public void setExp(int exp) 
	{
		this.exp = exp;
	}

	public String getOrganisationName() 
	{
		
		return organisationName;
	}
	public void setOrganisationName(String organisationName) 
	{
		this.organisationName = organisationName;
	}
	public String getDesignation() 
	{
	
		return designation;
	}
	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}
	
	public void setExperience()
	{
		Scanner s=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter Experience Details :");
		System.out.println();
		
		System.out.println("enter experience id");
		int id=s.nextInt();
		
		System.out.println("Enter organisation Name :");
		String organisationName=sc.nextLine();
			
	    System.out.println("Enter Designation :");
		String designation=sc.nextLine();
		
		System.out.println("Enter employee experience :");
		int exp=s.nextInt();
		
		PreparedStatement stmt=null;
		
		try {
			 stmt = con.prepareStatement("insert into experience values(?,?,?,?)");
			 stmt.setInt(1, id);
			 stmt.setString(2, organisationName);
			 stmt.setString(3,designation);
			 stmt.setInt(4,exp);
			 stmt.executeUpdate();
			 rs =stmt.executeQuery("select * from experience");
			 	 
		 System.out.println("Values Inserted successfully in experience");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
		
 public void getExperience()
 {
	 System.out.println("employee experience details are");
	 try {
		 Statement st=DBconnection.con.createStatement();
			String sql = "select * from experience";
			st = con.prepareStatement(sql);		
			rs = st.executeQuery(sql);

			ResultSetMetaData resultSetMetaData = rs.getMetaData();

			   int columnCount = resultSetMetaData.getColumnCount();

			   // Print column info
			   for (int i = 1; i <= columnCount; i++) 
			   {
			       System.out.print(resultSetMetaData.getColumnName(i) + "    ");
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


