package crochet_pattern.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crochet_pattern.dao.Crochet_patternDao;
import crochet_pattern.domain.Crochet_pattern;

/**
 * Servlet implementation class UserServlet
 */

public class Crochet_patternServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Crochet_patternServletUpdate() {
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
		Crochet_patternDao crochet_patternDao = new Crochet_patternDao();
		Crochet_pattern crochet = null;

		if(method.equals("search"))
		{
			try {
				crochet = crochet_patternDao.findBypattern_id(Integer.parseInt(request.getParameter("pattern_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(crochet.getPattern_id()!=null){
				request.setAttribute("crochet_pattern", crochet);
				request.getRequestDispatcher("/jsps/crochet_pattern/crochet_pattern_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Crochet pattern not found");
				request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Crochet_pattern form = new Crochet_pattern();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			//TODO fix
//			System.out.println(request.getParameter("pattern_id"));
			form.setPattern_id(Integer.parseInt(request.getParameter("pattern_id")));
			form.setPattern_link(request.getParameter("pattern_link"));
			form.setHook_size(Double.parseDouble(request.getParameter("hook_size")));
			form.setAuthor_id(Integer.parseInt(request.getParameter("author_id")));
			form.setCategory(request.getParameter("category"));
			

			try {
				crochet_patternDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Crochet Pattern Updated");
			request.getRequestDispatcher("/jsps/crochet_pattern/crochet_pattern_read_output.jsp").forward(request, response);
		}
	}
}



