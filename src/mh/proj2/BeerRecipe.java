package mh.proj2;

import java.util.HashSet;
import java.util.Set;

import mh.masutils.MASUtils;

public class BeerRecipe {

	private String name;
	private int id;
	
	private Set<Yeast> yeasts = new HashSet<>();//composition - yeast is an obligatory element of a beer recipe
	private Set<HopInBeerRecipe> hopsInBeerRecipe = new HashSet<>(); //association with an attribute
	private Set<Beer> beers = new HashSet<Beer>(); //qualified association
	
	public BeerRecipe(String name, int id) {
		super();
		setName(name);
		setId(id);
	}
	
	public Yeast createYeast(String name, String origin) {
		Yeast y = new Yeast(name, origin);
		yeasts.add(y);
		return y;
	}

	public BeerRecipe() {
		this.yeasts.add(new Yeast());
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(Integer id) {
		if (!MASUtils.isNull(id)){
			this.id = id;
		}
	}

	public void addBeer(Beer beer) {
		if (!this.beers.contains(beer)) {
			beers.add(beer);
			beer.addBeerRecipeQual(this);
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!MASUtils.isNull(name)) {
			this.name = name;
		}
	}

	public void addHopInBeerRecipe(HopInBeerRecipe e) {
		if (hopsInBeerRecipe.size() == 5) {
			throw new RuntimeException("there may be at most 5 hops in a beer recipe");
		}
		if (!hopsInBeerRecipe.contains(e)) {
			hopsInBeerRecipe.add(e);
			e.setBeerRecipe(this);
		}
	}
	
	public void removeHopInBeerRecipe(HopInBeerRecipe e) {
		if (hopsInBeerRecipe.contains(e)){
			hopsInBeerRecipe.remove(e);
			e.setBeerRecipe(null);
			e.setHop(null);
		}
	}
	
	public void removeYeast(Yeast y){
		if (yeasts.contains(y)){
			yeasts.remove(y);
		}
	}
	
	public void removeBeer(Beer b){
		if (beers.contains(b)){
			beers.remove(b);
			b.removeBeerRecipe(this.id);
		}
	}



	class Yeast { //composition class
		private String name;
		private String origin;
		
		public Yeast() {
			
		}
		
		public Yeast(String name, String origin) {
			setName(name);
			setOrigin(origin);
		}
		
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
