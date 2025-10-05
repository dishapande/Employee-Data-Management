package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   
		
		  response.setContentType("text/html");
		  
		   int id= Integer.parseInt(request.getParameter("id"));
		   
		           Employee e1 = EmpDao.getEmployeebyId(id);
		   
		           
//		         System.out.println(e.getId() + e.getName()+e.getPassword());
		           
		           PrintWriter out = response.getWriter();
		                
		           out.print("<form action='editServlet2' method='post' "
		        	        + "style='border:2px solid #333; padding:30px; width:400px; "
		        	        + "margin:auto; background-color:#f9f9f9; border-radius:10px; "
		        	        + "box-shadow: 2px 2px 12px rgba(0,0,0,0.2); font-family:Arial;'>");

		        	out.print("<h2 style='text-align:center; color:#444;'>Edit Employee</h2>");

		        	out.print("<label style='font-weight:bold;'>ID:</label><br>");
		        	out.print("<input type='number' name='id' value='"+e1.getId()+"' readonly "
		        	        + "style='width:100%; padding:8px; margin:8px 0; border-radius:5px; border:1px solid #ccc;'>");

		        	out.print("<label style='font-weight:bold;'>Name:</label><br>");
		        	out.print("<input type='text' name='name' value='"+e1.getName()+"' "
		        	        + "style='width:100%; padding:8px; margin:8px 0; border-radius:5px; border:1px solid #ccc;'>");

		        	out.print("<label style='font-weight:bold;'>Password:</label><br>");
		        	out.print("<input type='text' name='password' value='"+e1.getPassword()+"' "
		        	        + "style='width:100%; padding:8px; margin:8px 0; border-radius:5px; border:1px solid #ccc;'>");

		        	out.print("<label style='font-weight:bold;'>Email:</label><br>");
		        	out.print("<input type='text' name='email' value='"+e1.getEmail()+"' "
		        	        + "style='width:100%; padding:8px; margin:8px 0; border-radius:5px; border:1px solid #ccc;'>");

		        	out.print("<label style='font-weight:bold;'>Position:</label><br>");
		        	out.print("<input type='text' name='position' value='"+e1.getPosition()+"' "
		        	        + "style='width:100%; padding:8px; margin:8px 0; border-radius:5px; border:1px solid #ccc;'>");

		        	out.print("<label style='font-weight:bold;'>Country:</label><br>");
		        	out.print("<select name='country' style='width:100%; padding:8px; margin:8px 0; "
		        	        + "border-radius:5px; border:1px solid #ccc; background-color:white;'>");
		        	
		        	out.print("<option "+("india".equalsIgnoreCase(e1.getCountry()) ? "selected" : "")+">India</option>");
		        	out.print("<option "+("pakistan".equalsIgnoreCase(e1.getCountry()) ? "selected" : "")+">Pakistan</option>");
		        	out.print("<option "+("USA".equalsIgnoreCase(e1.getCountry()) ? "selected" : "")+">USA</option>");
		        	out.print("<option "+("UK".equalsIgnoreCase(e1.getCountry()) ? "selected" : "")+">UK</option>");
		        	out.print("</select>");

		        	out.print("<input type='submit' value='Edit And Save' "
		        	        + "style='width:100%; padding:10px; margin-top:15px; background-color:#007bff; "
		        	        + "color:white; border:none; border-radius:5px; font-weight:bold; cursor:pointer;'>");

		        	out.print("</form>");

		 
		
	}

}
