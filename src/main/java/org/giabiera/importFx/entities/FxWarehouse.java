package org.giabiera.importFx.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fx_warehouse")
public class FxWarehouse {
	
	private Long id;
	private Date dateCreated;
	private String orderingCurrency;
	private String toCurrency;
	private BigDecimal amount;
	
	public FxWarehouse() {
		
	}
	
	public FxWarehouse(Date dateCreated, String orderingCurrency, String toCurrency, BigDecimal amount ) {
		this.dateCreated = dateCreated;
		this.orderingCurrency = orderingCurrency;
		this.toCurrency = toCurrency;
		this.amount = amount;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="dateCreated", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Column(name="orderingCurrency", nullable=false)
	public String getOrderingCurrency() {
		return orderingCurrency;
	}
	public void setOrderingCurrency(String orderingCurrency) {
		this.orderingCurrency = orderingCurrency;
	}
	
	@Column(name="toCurrency", nullable=false)
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	@Column(name="amount", nullable=false)
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
