

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<a href='index.html'>Add new Employee</a>");
		out.println("<h>Employee List</h>");
		
		ArrayList<Emp> list=EmpDao.getAllEmployees();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Country</th><th>Gender</th><th>Phone</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getid()+"</td><td>"+e.getName()+"</td><td>"+e.getCountry()+"</td><td>"+e.getGender()+"</td><td>"+e.getphone()+"</td><td>"+e.getPassword()+"</td><td><a href='UpdateServlet?id="+e.getid()+"'>Edit</a></td><td><a href='DeleteServlet?id="+e.getid()+"'>Delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
		
	}


}
