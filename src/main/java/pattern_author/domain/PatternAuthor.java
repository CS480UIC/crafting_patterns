package pattern_author.domain;

import java.sql.Date;

/**
 * Pattern Author object
 * 
 * @author Martina Skalova
 * 
 */
public class PatternAuthor {

	private Integer author_id;
	private String full_name;
	private String user_language;
	private Date date_joined;
	/**	
	 * @return the author_id
	 */
	public Integer getAuthor_id() {
		return author_id;
	}
	/**
	 * @param author_id the author_id to set
	 */
	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the user_Language
	 */
	public String getUser_language() {
		return user_language;
	}
	/**
	 * @param user_Language the user_Language to set
	 */
	public void setUser_language(String user_Language) {
		this.user_language = user_Language;
	}
	/**
	 * @return the date_joined
	 */
	public Date getDate_joined() {
		return date_joined;
	}
	/**
	 * @param date_joined the date_joined to set
	 */
	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}
	
	
	
}
