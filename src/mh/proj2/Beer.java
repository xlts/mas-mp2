package mh.proj2;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import mh.masutils.MASUtils;

public class Beer {

	private String name;
	private Date brewingDate;
	
	private Set<Order> orders = new HashSet<>(); //binary association
	private Map<Integer, BeerRecipe> beerRecipeQual = new HashMap<>(); //qualified association
	
	public Beer(String name, Date brewingDate) {
		setName(name);
		setBrewingDate(brewingDate);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!MASUtils.isNull(name)) {
			this.name = name;
		}
	}

	public Date getBrewingDate() {
		return brewingDate;
	}

	public void setBrewingDate(Date brewingDate) {
		if (!MASUtils.isNull(brewingDate)) {
			this.brewingDate = brewingDate;
		}
	}
	
	public void addBeerRecipeQual(BeerRecipe beerRecipe) {
		if (!beerRecipeQual.containsKey(beerRecipe.getId())) {
			beerRecipeQual.put(beerRecipe.getId(), beerRecipe);
			beerRecipe.addBeer(this);
		}
	}
	
	public BeerRecipe findBeerRecipeQual(int id) { //find beer recipe by its id
		if (!beerRecipeQual.containsKey(id)) {
			throw new RuntimeException("No such key found");
		}
		
		return beerRecipeQual.get(id);
	}
	
	public void addOrder(Order o) {
		if (!orders.contains(o)){
			orders.add(o);
			o.addBeer(this);
		}
	}

	public void removeOrder(Order o) {
		if (orders.contains(o)){
			orders.remove(o);
			o.removeBeer(this);
		}
	}
	
	public void removeBeerRecipe(int id) {
		if(beerRecipeQual.containsKey(id)) {
			
			if (beerRecipeQual.size() == 1) {
				throw new RuntimeException("Beer needs to be based on at l");
			}
			
			BeerRecipe br = beerRecipeQual.get(id);
			beerRecipeQual.remove(id);
			br.removeBeer(this);
		}
	}
}
