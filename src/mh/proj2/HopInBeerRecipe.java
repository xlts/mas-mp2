package mh.proj2;

import mh.masutils.MASUtils;

//associative class
public class HopInBeerRecipe {

	private BeerRecipe beerRecipe;
	private Hop hop;
	
	private HopInBeerRecipeFunction function;
	
	public HopInBeerRecipe(HopInBeerRecipeFunction f) {
		if (!MASUtils.isNull(f)){
			this.function = f;
		}
	}

	public BeerRecipe getBeerRecipe() {
		return beerRecipe;
	}

	public void setBeerRecipe(BeerRecipe beerRecipe) {
		if (this.beerRecipe != beerRecipe) {
			this.beerRecipe = beerRecipe;
			beerRecipe.addHopInBeerRecipe(this);
		}
	}

	public Hop getHop() {
		return hop;
	}

	public void setHop(Hop hop) {
		if (this.hop != hop) {
			this.hop = hop;
			hop.addHopInBeerRecipe(this);
		}
	}

	public HopInBeerRecipeFunction getFunction() {
		return function;
	}

	public void setFunction(HopInBeerRecipeFunction function) {
		if (!MASUtils.isNull(function))
			this.function = function;
	}
	
	
	
}
