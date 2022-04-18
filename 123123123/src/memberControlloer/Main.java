package memberControlloer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main2")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Main() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		request.setAttribute("id", id);
		
		RequestDispatcher dis = request.getRequestDispatcher("step1_01_loginEx1/01_main.jsp");
		dis.forward(request, response);
	
	}

	
	

}
