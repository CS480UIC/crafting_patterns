package crochet_pattern.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crochet_pattern.dao.Crochet_patternDao;
import crochet_pattern.domain.Crochet_pattern;


/**
 * Servlet implementation class UserServlet
 */

public class Crochet_patternServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crochet_patternServletDelete() {
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
		Crochet_patternDao patternDao = new Crochet_patternDao();
		Crochet_pattern pattern = null;
		if(method.equals("search"))
		{
			try {
				pattern = patternDao.findBypattern_id(Integer.parseInt(request.getParameter("pattern_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(pattern.getPattern_id()!=null){
						System.out.println(pattern);
						request.setAttribute("crochet_pattern", pattern);
						request.getRequestDispatcher("/jsps/crochet_pattern/crochet_pattern_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Crochet Pattern not found");
				request.getRequestDispatcher("/jsps/crochet_pattern/crochet_pattern_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				patternDao.delete(request.getParameter("pattern_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Crochet Pattern Deleted");
			request.getRequestDispatcher("/jsps/crochet_pattern/crochet_pattern_read_output.jsp").forward(request, response);
		}
	}
}



