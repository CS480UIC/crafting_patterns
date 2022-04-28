package pattern_author.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern_author.dao.PatternAuthorDao;
import pattern_author.domain.PatternAuthor;


/**
 * Servlet implementation class UserServlet
 */

public class PatternAuthorServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatternAuthorServletDelete() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String method = request.getParameter("method");
//		PatternAuthorDao entity1Dao = new PatternAuthorDao();
//		PatternAuthor entity1 = null;
//		if(method.equals("search"))
//		{
//			try {
//				entity1 = entity1Dao.findByAuthorId(request.getParameter("username"));
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			} catch (InstantiationException e1) {
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				e1.printStackTrace();
//			}
//		
//			if(entity1.getUsername()!=null){
//						System.out.println(entity1);
//						request.setAttribute("entity1", entity1);
//						request.getRequestDispatcher("/jsps/entity1/entity1_delete_output.jsp").forward(request, response);			
//				}
//				else{
//				request.setAttribute("msg", "Entity not found");
//				request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
//			}
//		}
//		else if(method.equals("delete"))
//		{	
//			try {
//				entity1Dao.delete(request.getParameter("username"));
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			} catch (InstantiationException e1) {
//				e1.printStackTrace();
//			} catch (IllegalAccessException e1) {
//				e1.printStackTrace();
//			}
//			request.setAttribute("msg", "Entity Deleted");
//			request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
//		}
	}
}



