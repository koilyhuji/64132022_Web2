

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BMI
 */
@WebServlet("/BMI")
public class BMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head><title>Tính BMI</title>");
	        out.println("<style>");
	        out.println("body { font-family: Arial, sans-serif; text-align: center; margin: 50px; background-color: #f4f4f4; }");
	        out.println(".container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1); display: inline-block; }");
	        out.println("input { padding: 10px; margin: 10px; width: 200px; }");
	        out.println("button { padding: 10px 20px; background-color: blue; color: white; border: none; cursor: pointer; }");
	        out.println("</style></head>");
	        out.println("<body>");
	        out.println("<div class='container'>");
	        out.println("<h2>Tính chỉ số BMI</h2>");
	        out.println("<form action='BMI' method='post'>");
	        out.println("Chiều cao (m): <input type='text' name='height' required><br>");
	        out.println("Cân nặng (kg): <input type='text' name='weight' required><br>");
	        out.println("<button type='submit'>Tính BMI</button>");
	        out.println("</form>");
	        out.println("</div>");
	        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String heightStr = request.getParameter("height");
        String weightStr = request.getParameter("weight");
        
        try {
            double height = Double.parseDouble(heightStr);
            double weight = Double.parseDouble(weightStr);
            double bmi = weight / (height * height);
            String result;
            
            if (bmi < 18.5) {
                result = "Gầy";
            } else if (bmi < 24.9) {
                result = "Bình thường";
            } else if (bmi < 29.9) {
                result = "Thừa cân";
            } else {
                result = "Béo phì";
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Kết quả BMI</title></head>");
            out.println("<body>");
            out.println("<h2>Kết quả BMI</h2>");
            out.println("<p>Chiều cao: " + height + " m</p>");
            out.println("<p>Cân nặng: " + weight + " kg</p>");
            out.println("<p><strong>BMI: " + String.format("%.2f", bmi) + "</strong></p>");
            out.println("<p>Phân loại: " + result + "</p>");
            out.println("<a href='BMI'>Tính lại</a>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Vui lòng nhập số hợp lệ!</p>");
            out.println("<a href='BMI'>Quay lại</a>");
        }
	}

}
