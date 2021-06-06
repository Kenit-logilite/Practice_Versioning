import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public SaveServlet() {
        super();

    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		Emp e = new Emp();
		e.setName(name);
		e.setCountry(country);
		e.setGender(gender);
		e.setPhone(phone);
		e.setPassword(password);
		

		int status=EmpDao.insert(e);
		if(status>0){
			out.print("Record saved successfully!");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
		
	}

}
