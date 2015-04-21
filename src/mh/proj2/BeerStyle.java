package mh.proj2;

import mh.masutils.MASUtils;

//seems redundant...
public class BeerStyle {

	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (!MASUtils.isNull(name))
			this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (!MASUtils.isNull(description))
			this.description = description;
	}
	
	
	
}
