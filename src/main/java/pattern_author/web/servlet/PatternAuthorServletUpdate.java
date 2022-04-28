package pattern_author.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern_author.dao.PatternAuthorDao;
import pattern_author.domain.PatternAuthor;

/**
 * Servlet implementation class UserServlet
 */

public class PatternAuthorServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatternAuthorServletUpdate() {
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
					request.getRequestDispatcher("/jsps/pattern_author/pattern_author_update_output.jsp").forward(request, response);
	
				}
				else{
					request.setAttribute("msg", "Pattern Author not found");
					request.getRequestDispatcher("/jsps/pattern_author/pattern_author_read_output.jsp").forward(request, response);
				}
			}
			else if(method.equals("update"))
			{
				Map<String,String[]> paramMap = request.getParameterMap();
				PatternAuthor form = new PatternAuthor();
				List<String> info = new ArrayList<String>();
	
				for(String name : paramMap.keySet()) {
					String[] values = paramMap.get(name);
					info.add(values[0]);
				}
				
				form.setAuthor_id(Integer.parseInt(info.get(1)));
				form.setFull_name(request.getParameter("full_name"));
				form.setUser_language(request.getParameter("user_language"));		
				form.setDate_joined(java.sql.Date.valueOf(request.getParameter("date_joined")));
				
				try {
					authorDao.update(form);
	
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				request.setAttribute("msg", "Pattern Author Updated");
				request.getRequestDispatcher("/jsps/pattern_author/pattern_author_read_output.jsp").forward(request, response);
			}
	}
}



