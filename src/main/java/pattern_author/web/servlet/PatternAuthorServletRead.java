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

public class PatternAuthorServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatternAuthorServletRead() {
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
		PatternAuthor pattern_author = null;
		PatternAuthorDao authorDao = new PatternAuthorDao();
		
		try {
			pattern_author = authorDao.findByAuthorId(Integer.parseInt(request.getParameter("author_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(pattern_author.getAuthor_id ()!=null){
//					System.out.println(pattern_author);
					request.setAttribute("pattern_author", pattern_author);
					request.getRequestDispatcher("/jsps/pattern_author/pattern_author_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Pattern Author not found");
			request.getRequestDispatcher("/jsps/pattern_author/pattern_author_read_output.jsp").forward(request, response);
		}
	}
}



