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

import pattern_author.domain.PatternAuthor;
import pattern_author.service.PatternAuthorException;
import pattern_author.service.PatternAuthorService;


/**
 * Servlet implementation class UserServlet
 */

public class PatternAuthorServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatternAuthorServletCreate() {
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
		PatternAuthorService patternAuthorService = new PatternAuthorService();
		Map<String,String[]> paramMap = request.getParameterMap();
		PatternAuthor form = new PatternAuthor();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setAuthor_id(Integer.parseInt(info.get(0)));
		form.setFull_name(info.get(1));
		form.setUser_language(info.get(2));		
		form.setDate_joined(java.sql.Date.valueOf(info.get(3)));	
		
		try {
			patternAuthorService.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | PatternAuthorException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
