package yarn.service;

import java.util.List;

import javax.servlet.http.HttpServlet;

import yarn.dao.YarnDao;
import yarn.domain.Yarn;



/**
 * logic functions such as register, login
 * @author Aayush Makharia
 */
public class YarnReadService  extends HttpServlet {
	private YarnDao yarnDao = new YarnDao();
	
	/**
	 * return all as list
	 */
	public List<Object> readAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return yarnDao.read();

	}

}
 