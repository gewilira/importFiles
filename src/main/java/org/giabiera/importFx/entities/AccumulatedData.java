package org.giabiera.importFx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccumulatedData {

	private String orderingCurrency;
	private Integer countOfDeals;
	
	public AccumulatedData(){}
	
	public AccumulatedData(String orderingCurrency, Integer countOfDeals) {
		this.orderingCurrency = orderingCurrency;
		this.countOfDeals = countOfDeals;
	}

	@Id
	public String getOrderingCurrency() {
		return orderingCurrency;
	}

	public void setOrderingCurrency(String orderingCurrency) {
		this.orderingCurrency = orderingCurrency;
	}

	@Column(nullable=false)
	public Integer getCountOfDeals() {
		return countOfDeals;
	}

	public void setCountOfDeals(Integer countOfDeals) {
		this.countOfDeals = countOfDeals;
	}
	
	public void incrementCountOfDeals(){
		this.countOfDeals++;
	}
	
}
