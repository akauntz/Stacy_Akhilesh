

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IWorkWithJSPServlet
 */
@WebServlet("/greetingsServletNew")
public class IWorkWithJSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IWorkWithJSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String greet="Bonjour "+request.getParameter("name");
		
	
		Object count = request.getSession().getAttribute("counter");
		String counter="";
		if (count==null) {
			counter="1";
		}else {
			counter=count.toString();
			int countInt=Integer.parseInt(counter);
			countInt++;
			counter=Integer.toString(countInt);
			}
		request.getSession().setAttribute("counter", counter);
		greet += "\nYou visited " + counter + " times!!";
		
		request.setAttribute("personalizedGreeting", greet);
		RequestDispatcher rs = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/NewGreetingsJSP.jsp");

		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
