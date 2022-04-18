package memberControlloer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_Dao.MemberDao;
import login_Dto.MemberDto;



@WebServlet("/join2")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Join() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher("step1_01_loginEx1/02_join.jsp");
		dis.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MemberDto memberDto = new MemberDto();
		
		memberDto.setId(request.getParameter("id"));
		memberDto.setPw(request.getParameter("pw"));
		memberDto.setName(request.getParameter("name"));
		memberDto.setTel(request.getParameter("tel"));
		memberDto.setEmail(request.getParameter("email"));
		
		boolean isJoin = MemberDao.getInstance().joinMember(memberDto);
		RequestDispatcher dis = request.getRequestDispatcher("step1_01_loginEx1/03_joinAction.jsp");
		dis.forward(request, response);
		
		
	}

}
