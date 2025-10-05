package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String password= request.getParameter("password");
		String email=request.getParameter("email");
		String position=request.getParameter("position");
		String country = request.getParameter("country");
		
		PrintWriter out = response.getWriter();
		
		
//		out.print("welcome  "+   name);
		
		Employee e1 = new Employee();
		e1.setName(name);
		e1.setPassword(password);
		e1.setEmail(email);
		e1.setPosition(position);
		e1.setCountry(country);
		
		
		int status= EmpDao.save(e1);
		    
		if(status > 0) {
		    // Data saved successfully
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Data saved successfully');");
		    out.println("window.location.href='ViewServlet';"); // redirect to list page
		    out.println("</script>");
		} else {
		    // Error saving
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Sorry! Unable to save data');");
		    out.println("window.location.href='addEmployeeForm.jsp';"); // redirect back to form
		    out.println("</script>");
		}
		
	}

}