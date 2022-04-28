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
		String method = request.getParameter("method");
		PatternAuthorDao authorDao = new PatternAuthorDao();
		PatternAuthor author = null;
		if(method.equals("search"))
		{
			try {
				author = authorDao.findByAuthorId(Integer.parseInt(request.getParameter("author_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(author.getAuthor_id()!=null){
						request.setAttribute("pattern_author", author);
						request.getRequestDispatcher("/jsps/pattern_author/pattern_author_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Pattern author not found");
				request.getRequestDispatcher("/jsps/pattern_author/pattern_author_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				authorDao.delete(Integer.parseInt(request.getParameter("author_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Pattern Author Deleted");
			request.getRequestDispatcher("/jsps/pattern_author/pattern_author_read_output.jsp").forward(request, response);
		}
	}
}



