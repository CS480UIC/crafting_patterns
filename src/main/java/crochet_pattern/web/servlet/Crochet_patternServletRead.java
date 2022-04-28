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

public class Crochet_patternServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crochet_patternServletRead() {
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
		Crochet_pattern crochet_pattern = null;
		Crochet_patternDao crochet_patternDao = new Crochet_patternDao();
		
		try {
			crochet_pattern = crochet_patternDao.findBypattern_id(Integer.parseInt(request.getParameter("pattern_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(crochet_pattern.getAuthor_id() != null){
					System.out.println(crochet_pattern);
					request.setAttribute("crochet_pattern", crochet_pattern);
					request.getRequestDispatcher("/jsps/crochet_pattern/crochet_pattern_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Crochet pattern not found");
			request.getRequestDispatcher("/jsps/crochet_pattern/crochet_pattern_read_output.jsp").forward(request, response);
		}
	}
}



