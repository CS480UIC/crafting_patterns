package user.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;

/**
 * Servlet implementation class findAll
 */

public class findAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userservice = new UserService();
		String [] placeArr = request.getParameterValues("JSPstatement");
//		System.out.println("JSPstatement: " + placeArr[0]);
		if (placeArr == null) {
			try {
				request.setAttribute("UserList", userservice.findall());
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				List<Object> li = userservice.findall();
				for(int i = 0; i < li.size();i++){
					System.out.println(li.get(i).toString());
				}
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			request.getRequestDispatcher("/jsps/user/q1_list_users.jsp").forward(request, response);
		} else {
			try {
				request.setAttribute("UserList", userservice.doThis(placeArr[0]));
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				List<Object> li = userservice.doThis(placeArr[0]);
				for(int i = 0; i < li.size();i++){
					System.out.println("any query list: " +li.get(i).toString());
				}
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			request.getRequestDispatcher("/jsps/user/anyQuery.jsp").forward(request, response);
		}

	}

}
