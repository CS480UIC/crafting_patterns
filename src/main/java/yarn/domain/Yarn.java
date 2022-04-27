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


	public void set1(String yarn_id) {
		 this.yarn_id = yarn_id;
	}
	public String get2() {
		return weight;
	}

	public void set2(String weight) {
		 this.weight = weight;
	}
	public String get3() {
		return yardage;
	}
	public void set3(String yardage) {
		 this.yardage = yardage;
	}
	public String get4() {
		return fiber;
	}

	public void set4(String fiber) {
		 this.fiber = fiber;
	}

	public String get5() {
		return recommended_hook_size;
	}

	public void set5(String recommended_hook_size) {
		 this.recommended_hook_size = recommended_hook_size;
	}

	public String get6() {
		return recommended_needle_size;
	}
	public void set6(String recommended_needle_size) {
		 this.recommended_needle_size = recommended_needle_size;
	}
	public String get7() {
		return name;
	}
	public void set7(String name) {
		 this.name = name;
	}
	public String get8() {
		return manufacturer;
	}

	public void set8(String manufacturer) {
		 this.manufacturer = manufacturer;
	}

	

	
	@Override
	public String toString() {
		return "User [ yarn_id=" + yarn_id + ", weight="
				+ weight + ", yardage=" + yardage + ", fiber=" + fiber + ", recommended_hook_size="
				+ recommended_hook_size + ", recommended_needle_size=" + recommended_needle_size 
				+ ", name=" + name + ", manufacturer=" + manufacturer + "]";
	}
}
