package yarn.service;

import java.util.List;

import javax.servlet.http.HttpServlet;

import user.domain.User;
import user.service.UserException;
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
	/**
	 * Register a user
	 */
	public void create(Yarn form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		Yarn yarn = yarn.findByUsername(form.getUsername());
//		if(user.getUsername()!=null && user.getUsername().equals(form.getUsername())) throw new UserException("This user name has been registered!");
		yarnDao.add(form);
	}
	public void update(Yarn form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		Yarn yarn = yarn.findByUsername(form.getUsername());
//		if(user.getUsername()!=null && user.getUsername().equals(form.getUsername())) throw new UserException("This user name has been registered!");
		yarnDao.update(form);
	}
	
	public List<Object> delete(String id) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		

		List<Object> ret = yarnDao.delete(id);
		System.out.println(ret);
		return ret;
	}

}
 