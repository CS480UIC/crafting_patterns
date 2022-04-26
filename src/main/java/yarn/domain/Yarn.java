package yarn.domain;

/**
 * User object
 * @author Aayush Makharia
 */
public class Yarn {
	/*
	 * Correspond to the user table
	 */
	
	public String yarn_id;
	public String weight; 
	public String yardage;
	public String fiber;
	public String recommended_hook_size;
	public String recommended_needle_size;
	public String name;
	public String manufacturer;
	

	public String get1() {
		return yarn_id;
	}



	public String get2() {
		return weight;
	}


	public String get3() {
		return yardage;
	}

	public String get4() {
		return fiber;
	}



	public String get5() {
		return recommended_hook_size;
	}



	public String get6() {
		return recommended_needle_size;
	}
	
	public String get7() {
		return name;
	}
	
	public String get8() {
		return manufacturer;
	}



	

	
	@Override
	public String toString() {
		return "User [ yarn_id=" + yarn_id + ", weight="
				+ weight + ", yardage=" + yardage + ", fiber=" + fiber + ", recommended_hook_size="
				+ recommended_hook_size + ", recommended_needle_size=" + recommended_needle_size 
				+ ", name=" + name + ", manufacturer=" + manufacturer + "]";
	}
}
