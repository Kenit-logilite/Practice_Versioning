

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String country=request.getParameter("country");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");

		
		Emp e=new Emp();
		e.setid(id);
		e.setName(name);
		e.setCountry(country);
		e.setGender(gender);
		e.setPhone(phone);
		e.setPassword(password);
		
		
		int status=EmpDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}