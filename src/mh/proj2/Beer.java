package mh.proj2;

import java.util.HashMap;
import java.util.Map;

public class Beer {

	private Map<Integer, BeerRecipe> beerRecipeQual = new HashMap<>(); //qualified association
	
	public void addBeerRecipeQual(BeerRecipe beerRecipe) {
		if (!beerRecipeQual.containsKey(beerRecipe.getId())) {
			beerRecipeQual.put(beerRecipe.getId(), beerRecipe);
			beerRecipe.addBeer(this);
		}
	}
	
	public BeerRecipe findBeerRecipeQual(int id) {
		if (!beerRecipeQual.containsKey(id)) {
			throw new RuntimeException("No such key found");
		}
		
		return beerRecipeQual.get(id);
	}
}
