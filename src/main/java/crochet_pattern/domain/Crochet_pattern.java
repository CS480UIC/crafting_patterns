package crochet_pattern.domain;

/**
 * crochet_pattern object
 * 
 * @author Martina Skalova
 * 
 */
public class Crochet_pattern {

	private String pattern_link;
	private Double hook_size;
	private Integer author_id;
	private String category;
	private Integer pattern_id;
	/**
	 * @return the author_id
	 */
	public Integer getAuthor_id() {
		return author_id;
	}
	/**
	 * @param author_id the author_id to set
	 */
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	/**
	 * @return the pattern_id
	 */
	public Integer getPattern_id() {
		return pattern_id;
	}
	/**
	 * @param pattern_id the pattern_id to set
	 */
	public void setPattern_id(Integer pattern_id) {
		this.pattern_id = pattern_id;
	}
	/**
	 * @return the pattern_link
	 */
	public String getPattern_link() {
		return pattern_link;
	}
	/**
	 * @param pattern_link the pattern_link to set
	 */
	public void setPattern_link(String pattern_link) {
		this.pattern_link = pattern_link;
	}
	/**
	 * @return the hook_size
	 */
	public Double getHook_size() {
		return hook_size;
	}
	/**
	 * @param hook_size the hook_size to set
	 */
	public void setHook_size(Double hook_size) {
		this.hook_size = hook_size;
	}
	/**
	 * @return the author_id
	 */

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**

	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
