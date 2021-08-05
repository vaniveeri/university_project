package mainApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import employeePackage.Employee;
import studentpackage.Student;
import utilities.Address;
import utilities.education;
public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException {
	
		// TODO Auto-generated method stub
		Collection<Employee> c = new ArrayList<Employee>();
		Collection<Student> s = new ArrayList<Student>();
		Scanner sc=new Scanner(System.in);
		int choice;
		do
		{

			 System.out.println("University Details");
		     System.out.println("Menu");
			 System.out.println("enter 1  for  student details");
			 System.out.println("enter 2 for  Employee details");
		     System.out.println("enter 3 for exit");
			 System.out.println("Please enter your choice:");
			   //Get user's choice
			 
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			int ch;
			do {
			System.out.println("student sub menu");
			System.out.println("1. Insert Student details");
			System.out.println("2. Display Student details");
			System.out.println("3. exit from menu");
			System.out.println("Please Enter Your choice");
			
			
			ch=sc.nextInt();
			
			switch(ch)
			{
			 case 1:
				System.out.println("enter number of students:");
				   int n=sc.nextInt();
				for (int i = 0; i < n; i ++)
				   {
					   Student student = new Student();
					   student.setStudentDetails(); 
					   s.add(student);
				   }
			
				break;
			
		      case 2:
					
						System.out.println("student whole details are");
						Student student = new Student();
						student.getStudentDetails(); 
						break;
		      case 3:
			    	System.out.println("exit");
			    	break;
			      
				}
				}while(ch!=3);
			}
			   
			break;

		case 2:
	
			int ch1;
			do
			{
			System.out.println("Employee sub menu");
			System.out.println("1. Insert Employee details");
			System.out.println("2. Display Employee details");
			System.out.println("3. exit from submenu");
			System.out.println("Please Enter Your choice");
			ch1=sc.nextInt();
			
			switch(ch1)
			{
			case 1:
				System.out.println("enter number of Employees:");
				 
				   int n1=sc.nextInt();
	               for (int i = 0; i < n1; i ++)
				   {
					   Employee emp = new Employee();
					   emp.setEmployeeDetails();
					
					   c.add(emp);
				   }  
	               break;
			case 2:
						System.out.println("Employee whole details are");
						Employee emp = new Employee();
						emp.getEmployeeDetails(); 
				
					break;
	        case 3: 
				 System.out.println("exit");
			    	break;
			      
				}
				}while(ch1!=3);
				
			   break;
		
			   
		case 3: {
					System.out.println("exit");
					System.exit(0);
					break;
				
				}

			}
		}while (choice != 3);

		}
	}
	




