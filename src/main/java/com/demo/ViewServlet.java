package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		displayPage(request, response, null);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String country = request.getParameter("country");

        // Create Employee object
        Employee e = new Employee();
        e.setName(name);
        e.setPassword(password);
        e.setEmail(email);
        e.setPosition(position);
        e.setCountry(country);

        // Save employee using your DAO
        EmpDao.save(e);  // Make sure you have this method

        // Show success message
        String message = "Employee added successfully!";

        displayPage(request, response, message);
    }

    private void displayPage(HttpServletRequest request, HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>Employee Data</h1>");

        // Show success message if any
        if (message != null) {
            out.print("<p style='color:green; font-weight:bold;'>" + message + "</p>");
        }

        // Add Employee button
        out.print("<button onclick='showForm()' style='margin-bottom:20px;'>Add New Employee</button>");

        // Add Employee form (hidden by default)
        out.print("<div id='addForm' style='display:none; border:1px solid black; padding:20px; margin-bottom:20px;'>");
        out.print("<h3>Add New Employee</h3>");
        out.print("<form action='ViewServlet' method='post'>");  
        out.print("Name: <input type='text' name='name' required><br><br>");
        out.print("Password: <input type='password' name='password' required><br><br>");
        out.print("Email: <input type='email' name='email' required><br><br>");
        out.print("Position: <input type='text' name='position' required><br><br>");
        out.print("Country: <input type='text' name='country' required><br><br>");
        out.print("<input type='submit' value='Add Employee'>");
        out.print("</form>");
        out.print("</div>");

        // Display table
        List<Employee> list = EmpDao.getAllEmployee();
        out.print("<table border cellspacing='0' cellpadding='10'>");
        out.print("<tr>");
        out.print("<th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Position</th><th>Country</th><th>Edit</th><th>Delete</th>");
        out.print("</tr>");

        for (Employee e1 : list) {
            out.print("<tr>");
            out.print("<td>" + e1.getId() + "</td>");
            out.print("<td>" + e1.getName() + "</td>");
            out.print("<td>" + e1.getPassword() + "</td>");
            out.print("<td>" + e1.getEmail() + "</td>");
            out.print("<td>" + e1.getPosition() + "</td>");
            out.print("<td>" + e1.getCountry() + "</td>");
            out.print("<td><a href='editServlet?id=" + e1.getId() + "' style='background:skyblue;color:black;padding:6px 12px;border-radius:4px;text-decoration:none;transition:0.3s;' onmouseover=\"this.style.background='#45a049'\" onmouseout=\"this.style.background='#4CAF50'\">Edit</a></td>");
            out.print("<td><a href='deleteServlet?id=" + e1.getId() + "' style='background:#f44336;color:black;padding:6px 12px;border-radius:4px;text-decoration:none;transition:0.3s;' onmouseover=\"this.style.background='#da190b'\" onmouseout=\"this.style.background='#f44336'\">Delete</a></td>");

            out.print("</tr>");
        }
        out.print("</table>");

        // JavaScript to toggle form
        out.print("<script>");
        out.print("function showForm() {");
        out.print("  var form = document.getElementById('addForm');");
        out.print("  if(form.style.display === 'none') { form.style.display = 'block'; }");
        out.print("  else { form.style.display = 'none'; }");
        out.print("}");
        out.print("</script>");
  
	}

}