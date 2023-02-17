package hi1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hi")
public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		java.sql.Date date = java.sql.Date.valueOf(request.getParameter("birthday"));
		String gender = request.getParameter("gender");
		String national = request.getParameter("national");
		String[] hobby = request.getParameterValues("hobbies");

		
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<!doctype html>\n").append("<html>\n").append("<head>\n")
									  .append("</head>\n").append("<body>\n")
									  .append("<h1> 이름 : " + name + "<br>")
									  .append(" 나이 : " + age + "<br>").append("생일 : " + date + "<br>")
									  .append("성별 : " + gender + "<br>").append("국적 : " + national + "<br>")
									  .append("취미 : " + Arrays.toString(hobby) + "<br>" ).append("</h1>\n")
									  .append("</body>\n")
									  .append("</html>");
		
		out.print(sb.toString());
		
		out.flush();
		
		out.close();

	}

}
