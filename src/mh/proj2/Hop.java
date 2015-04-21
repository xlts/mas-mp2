package mh.proj2;

import java.util.HashSet;
import java.util.Set;

import mh.masutils.MASUtils;

public class Hop {

	private String name;
	private double alphaAcidPercentage;
	
	private Set<HopInBeerRecipe> hopsInBeerRecipe = new HashSet<>(); //association with an attribute

	public Hop(String name, double alphaAcidPercentage) {
		super();
		setName(name);
		setAlphaAcidPercentage(alphaAcidPercentage);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!MASUtils.isNull(name)) {
			this.name = name;
		}
	}

	public double getAlphaAcidPercentage() {
		return alphaAcidPercentage;
	}

	public void setAlphaAcidPercentage(Double alphaAcidPercentage) {
		if (!MASUtils.isNull(name)) {
			this.alphaAcidPercentage = alphaAcidPercentage;
		}
	}

	public void addHopInBeerRecipe(HopInBeerRecipe e) {
		if (!hopsInBeerRecipe.contains(e)) {
			hopsInBeerRecipe.add(e);
			e.setHop(this);
		}
	}
	
	public void removeHopInBeerRecipe(HopInBeerRecipe e) {
		if (hopsInBeerRecipe.contains(e)){
			hopsInBeerRecipe.remove(e);
			e.setHop(null);
			e.setBeerRecipe(null);
		
		}
	}
	
}
