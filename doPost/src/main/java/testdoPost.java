

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class testdoPost
 */
@WebServlet("/testdoPost")
public class testdoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testdoPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter traVe =response.getWriter();
		traVe.append("Bạn vừa gửi yêu cầu dạng GET, đây là đáp ứng của tôi");
		String HTML = "<form method='POST' action='/Bai1.2/testdoPost'>"
	            + "<label> Họ: </label>"
	            + "<input type='text' name='ho'><br>"
	            + "<label> Tên: </label>"
	            + "<input type='text' name='ten'><br>"
	            + "<input type='submit' value='Gửi đi'>"
	            + "</form>";
		traVe.append(HTML);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String value1=request.getParameter("ho");
		String value2=request.getParameter("ten");
		PrintWriter traVe =response.getWriter();
		traVe.append("Bạn vừa gửi yêu cầu dạng POST, đây là đáp ứng của tôi");
		traVe.append("\nHọ: ");
		traVe.append(value1);
		traVe.append("\nTên: ");
		traVe.append(value2);
	}

}
