package org.giabiera.importFx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accumulated_data")
public class AccumulatedData {
	
	private Long id;
	private Integer countOfDeals;
	private String orderingCurrency;
	
	public AccumulatedData() {
		
	}
	
	public AccumulatedData(String orderingCurrency, Integer countOfDeals) {
		this.countOfDeals = countOfDeals;
		this.orderingCurrency = orderingCurrency;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "countOfDeals", nullable = false)
	public Integer getCountOfDeals() {
		return countOfDeals;
	}

	public void setCountOfDeals(Integer countOfDeals) {
		this.countOfDeals = countOfDeals;
	}
	
	@Column(name = "orderingCurrency",nullable = false,unique = true)
	public String getOrderingCurrency() {
		return orderingCurrency;
	}
	
	public void setOrderingCurrency(String orderingCurrency) {
		this.orderingCurrency = orderingCurrency;
	}
}
