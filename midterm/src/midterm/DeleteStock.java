package midterm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStock.do")
public class DeleteStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteStock() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDAO dao = new StockDAO();
		dao.delete(request.getParameter("stockCode"));
		RequestDispatcher rd = request.getRequestDispatcher("/DeleteSuccess.jsp");
		rd.forward(request, response);
	}

}
