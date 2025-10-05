package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editServlet2")
public class EditServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  response.setContentType("text/html");
		  
		  int id= Integer.parseInt(request.getParameter("id"));
		    String name = request.getParameter("name");
			String password= request.getParameter("password");
			String email=request.getParameter("email");
			String position=request.getParameter("position");
			String country = request.getParameter("country");
			
			PrintWriter out = response.getWriter();
			
			
//			out.print("welcome  "+   name);
			
			Employee e1 = new Employee();
			e1.setId(id);
			e1.setName(name);
			e1.setPassword(password);
			e1.setEmail(email);
			e1.setPosition(position);
			e1.setCountry(country);
		  
			
			int status=   EmpDao.update(e1);
			
			    if(status>0)
			    {
			    	  response.sendRedirect("ViewServlet");
			    }else
			    {
			    	 out.print("something went wrong");
			    }
		
		
	}

}