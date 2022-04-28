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

import crochet_pattern.domain.Crochet_pattern;
import crochet_pattern.service.Crochet_patternException;
import crochet_pattern.service.Crochet_patternService;


/**
 * Servlet implementation class UserServlet
 */

public class Crochet_patternServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crochet_patternServletCreate() {
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
		Crochet_patternService entity1service = new Crochet_patternService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Crochet_pattern form = new Crochet_pattern();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setPattern_link(info.get(0));
		form.setPattern_id(Integer.parseInt(info.get(1)));
		form.setHook_size(Double.parseDouble(info.get(2)));	
		form.setAuthor_id(Integer.parseInt(info.get(3)));
		form.setCategory(info.get(4));	
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Crochet_patternException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
