package mh.proj2;

import java.util.HashSet;
import java.util.Set;

import mh.masutils.MASUtils;

public class BeerRecipe {

	private String name;
	private int id;
	
	private final Yeast yeast; //composition - yeast is an obligatory element of a beer recipe
	private Set<HopInBeerRecipe> hopsInBeerRecipe = new HashSet<>(); //association with an attribute
	private Set<Beer> beers = new HashSet<Beer>(); //qualified association
	
	public BeerRecipe() {
		this.yeast = new Yeast();
	}
	
	public int getId() {
		return id;
	}

	public void addBeer(Beer beer) {
		if (!this.beers.contains(beer)) {
			beers.add(beer);
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!MASUtils.isNull(name))
			this.name = name;
	}
	
	

	public void addHopInBeerRecipe(HopInBeerRecipe e) {
		if (!hopsInBeerRecipe.contains(e)) {
			hopsInBeerRecipe.add(e);
			e.setBeerRecipe(this);
		}
	}



	class Yeast { //composition class
		private String name;
		private String origin;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			if (!MASUtils.isNull(name))
				this.name = name;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			if (!MASUtils.isNull(origin))
				this.origin = origin;
		}
	}
}
