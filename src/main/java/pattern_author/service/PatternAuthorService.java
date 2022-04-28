package pattern_author.service;


import pattern_author.dao.PatternAuthorDao;
import pattern_author.domain.PatternAuthor;

/**
 * logic functions such as register, login
 * @author Martina Skalova
 *
 */
public class PatternAuthorService {
	private PatternAuthorDao pattern_authorDao = new PatternAuthorDao();
	
	/**
	 * register a pattern author
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(PatternAuthor form) throws PatternAuthorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		PatternAuthor author = pattern_authorDao.findByAuthorId(form.getAuthor_id());
		if(author.getAuthor_id()!=null && author.getAuthor_id().equals(form.getAuthor_id())) throw new PatternAuthorException("This pattern author has been registered!");
		pattern_authorDao.add(form);
	}
}
