package mh.proj2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import mh.masutils.MASUtils;

public class Order {

	private int id;
	private Date orderDate;
	
	private Set<Beer> beers = new HashSet<>(); //binary association

	public Order(int id, Date orderDate){
		setId(id);
		setOrderDate(orderDate);
	}
	
	public void addBeer(Beer beer) {
		if (MASUtils.isNull(beer)) {
			throw new IllegalArgumentException("passed a null value");
		}
		if (!beers.contains(beer)) {
			beers.add(beer);
			beer.addOrder(this);
		}
	}
	
	public void removeBeer(Beer beer) {
		if (MASUtils.isNull(beer)) {
			throw new IllegalArgumentException("passed a null value");
		}
		if (beers.contains(beer)) {
			beers.remove(beer);
			beer.removeOrder(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		if (!MASUtils.isNull(id)) {
			this.id = id;
		}
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		if (!MASUtils.isNull(orderDate)) {
			this.orderDate = orderDate;
		}
	}
}
