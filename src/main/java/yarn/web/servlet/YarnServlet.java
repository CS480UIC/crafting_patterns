package yarn.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import yarn.service.YarnReadService;
import yarn.*;


/**
 * Servlet implementation class UserServlet
 */

public class YarnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YarnServlet() {
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
		System.out.println("called the servlet");
		YarnReadService yarnService = new YarnReadService();
		
			try {
				request.setAttribute("YarnList", yarnService.readAll());
			} catch ( Exception e) {
				e.printStackTrace();
			}
			try {
				List<Object> li = yarnService.readAll();
				for(int i = 0; i < li.size();i++){
					System.out.println(li.get(i).toString());
				}
				
			} catch ( Exception e) {
				e.printStackTrace();
			}
			
			
			request.getRequestDispatcher("/jsps/yarn/yarn_list.jsp").forward(request, response);
		}
		
	

}
