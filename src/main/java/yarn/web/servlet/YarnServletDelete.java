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

import yarn.domain.Yarn;
import yarn.service.YarnException;
import yarn.service.YarnReadService;
import yarn.*;

/**
 * Servlet implementation class UserServlet
 */

public class YarnServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YarnServletDelete() {
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
		YarnReadService yarnservice = new YarnReadService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Yarn form = new Yarn();
		List<String> info = new ArrayList<String>(8);
		int count = 0;
		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			System.out.println("values: "+values[0]);
			info.add(values[0]);
			count++;
//			info.se(values[0]);
		}
		System.out.println(info);
		form.set1(info.get(1));

//		form.set2(info.get(1));
//		form.set3(info.get(2));
//		form.set4(info.get(3));
//		form.set5(info.get(4));
//		form.set6(info.get(5));
//		form.set7(info.get(6));
//		form.set8(info.get(7));

		
		try {
			
			
			request.setAttribute("form", yarnservice.delete(form.yarn_id));
			System.out.println("yarnservice in yarn delete servlet: "+ yarnservice );
			System.out.println("request in yarn delete servlet: "+ request);
			request.getRequestDispatcher("/jsps/yarn/yarn_delete_output.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
