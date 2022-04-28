package crochet_pattern.service;


import crochet_pattern.dao.Crochet_patternDao;
import crochet_pattern.domain.Crochet_pattern;

/**
 * logic functions such as register, login
 * @author Martina Skalova
 *
 */
public class Crochet_patternService {
	private Crochet_patternDao crochet_pattern = new Crochet_patternDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Crochet_pattern form) throws Crochet_patternException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Crochet_pattern pattern = crochet_pattern.findBypattern_id(form.getPattern_id());
		if(pattern.getPattern_link()!=null && pattern.getPattern_link().equals(form.getPattern_link())) throw new Crochet_patternException("This getPattern_link has been registered!");
		crochet_pattern.add(form);
	}
}
