package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	   public static Connection getconnection()
	   {
		   Connection con=null;
		   try {
			   
			   Class.forName("com.mysql.jdbc.Driver");  
			con= DriverManager.getConnection("jdbc:mysql://localhost/employeedb","root","1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return con;
	   }
	   
	   
	   public static int save(Employee e)
	   {
		   int status=0;
		   
		   
		     
		     try {
		    	 Connection con= EmpDao.getconnection();
				PreparedStatement ps= con.prepareStatement("insert into emp (name,password,email,position,country)values(?,?,?,?,?)");

//		       String n1= e.getName();
//		         ps.setString(1, n1);
         
				    ps.setString(1, e.getName());
				    ps.setString(2, e.getPassword());
				    ps.setString(3, e.getEmail());
				    ps.setString(4, e.getPosition());
				    ps.setString(5, e.getCountry());
				    
			 status =ps.executeUpdate();
				
				
				
		     } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		     
		     
		     
		   
		   return status;
	   }
	
	   public static int update(Employee e) {
       	
           int status= 0;
        
                Connection con = EmpDao.getconnection();
                
                
                 try {
					PreparedStatement ps= con.prepareStatement("update  emp set name=?,password=?,email=?,position=?,country=? where id=?");
					
					  ps.setString(1, e.getName());
					  ps.setString(2, e.getPassword());
					  ps.setString(3, e.getEmail());
					  ps.setString(4, e.getPosition());
					  ps.setString(5, e.getCountry());
					  ps.setInt(6,e.getId());
					  
					  
					  status=ps.executeUpdate();
					  
					  
					  
					  System.out.println(e.getName()+ status);
					      
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 
           
			return status;
      
}
	   public static int delete(int id)
	   {
		     Connection con =EmpDao.getconnection();
		     int status=0;
		     try {
				PreparedStatement p = con.prepareStatement("delete from emp where id=? ");
				
				   p.setInt(1, id);
				
				   status= p.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		   return status;
	   }
	   public static Employee getEmployeebyId(int id)
	   {
		   Employee e= new Employee();
    	   
      	 Connection con = EmpDao.getconnection();
             try {
				PreparedStatement p= con.prepareStatement("select * from emp where id=?");
			         
				p.setInt(1, id);
				
				ResultSet rs= p.executeQuery();
				
				   if(rs.next())
				   {
					    e.setId(rs.getInt(1)); 
					    e.setName(rs.getString(2));
					    e.setPassword(rs.getString(3));
					    e.setEmail(rs.getString(4));
					    e.setPosition(rs.getString(5));
					    e.setCountry(rs.getString(6));
					    
				   }
				
				
        
             } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                     
      	             
      	 
      	 return e;
       }
       
       
	   
	   public static List<Employee> getAllEmployee()
	   {
		   ArrayList<Employee> list  = new ArrayList<Employee>();
		   Connection con=EmpDao.getconnection();
		   
		      try {
				PreparedStatement p= con.prepareStatement("select * from emp");
				
				   ResultSet rs =p.executeQuery();
				   
				   
				     while(rs.next())
				     {
				    	    Employee e1= new Employee();
				    	       e1.setId(rs.getInt("id"));
				    	       e1.setName(rs.getString("name"));
				    	       e1.setPassword(rs.getString("password"));
				    	       e1.setEmail(rs.getString("email"));
				    	       e1.setPosition(rs.getString("position"));
				    	       e1.setCountry(rs.getString("country"));
				    	       list.add(e1);
				    	 
				     }
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		   
		   return list;
	   }
	

}
