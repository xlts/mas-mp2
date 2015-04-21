package mh.proj2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy, MM, dd");
		BeerRecipe br1 = new BeerRecipe("Pilsner", 1);
		
		br1.createYeast("Saflager S-33", "Czech Republic");
		
		BeerRecipe br2 = new BeerRecipe("American Pale Ale", 2);
		br2.createYeast("Wyeast California Ale", "USA");
		
		Beer b1 = new Beer("Czech Pilsner Saaz", sdf.parse("2015, 04, 01"));
		Beer b2 = new Beer("West Coast Pale Ale", sdf.parse("2015, 04, 10"));
		
		br1.addBeer(b1);
		br2.addBeer(b2);
		
		System.out.println("Beer recipe with id 1: " + b1.findBeerRecipeQual(1).getName());
		
		Hop h1 = new Hop("Saaz", 4);
		Hop h2 = new Hop("Citra", 12);
		
		HopInBeerRecipe saazInbr1 = new HopInBeerRecipe(HopInBeerRecipeFunction.BITTERING);
		HopInBeerRecipe citraInbr1 = new HopInBeerRecipe(HopInBeerRecipeFunction.AROMA);
		saazInbr1.setBeerRecipe(br1);
		citraInbr1.setBeerRecipe(br1);
		
		Order o1 = new Order(1, sdf.parse("2015, 04, 18"));
		o1.addBeer(b1);
		o1.addBeer(b2);
		
	}

}
