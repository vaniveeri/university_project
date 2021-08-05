package utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import util.DBconnection;
public class education {
		public int education_id;
		public  String course;
		public  String university;
		public String place;
		public  float marks;
		public int yop;
		
		Connection con = DBconnection.getConnection();
		ResultSet rs=null;
		PreparedStatement stmt=null;

		
		


		public int getEducation_id() {
			return education_id;
		}


		public void setEducation_id(int education_id) {
			this.education_id = education_id;
		}


		public String getCourse() {
			return course;
		}


		public void setCourse(String course) {
			this.course = course;
		}


		public String getUniversity() {
			return university;
		}


		public void setUniversity(String university) {
			this.university = university;
		}


		public String getPlace() {
			return place;
		}


		public void setPlace(String place) {
			this.place = place;
		}


		public float getMarks() {
			return marks;
		}


		public void setMarks(float marks) {
			this.marks = marks;
		}


		public int getYop() {
			return yop;
		}


		public void setYop(int yop) {
			this.yop = yop;
		}


		public void setEducationDetails()
		{
			
			Scanner sc=new Scanner(System.in);
	        Scanner sc1=new Scanner(System.in);
	    	
	        System.out.println("enter education id");
	        int education_id=sc.nextInt();
			System.out.print("enter course:");
			String course=sc1.nextLine();
			
			System.out.println("enter university:");
			String university=sc1.nextLine();
			System.out.println("enter place:");
			String place=sc1.nextLine();
			System.out.println("enter marks:");
			Float marks=sc.nextFloat();
			System.out.println("enter year of passing:");
			int yop=sc.nextInt();
			try {
				 stmt = con.prepareStatement("insert into education values(?,?,?,?,?,?)");
				 stmt.setInt(1, education_id);
				 stmt.setString(2, course);
				 stmt.setString(3,university);
				 stmt.setString(4,place);
				 stmt.setFloat(5, marks);
				 stmt.setInt(6,yop);
				 stmt.executeUpdate();
				 rs =stmt.executeQuery("select * from education");
				 
			 System.out.println("Values Inserted successfully in education");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}
	
		public void getEducation()
		{
			
           System.out.println("education details are:");
		    try {
			
			String sql = "select * from education";
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





