package com.cs.trade.tradeprocessingsystem.model;

/**
* @author SoumyaRanjan Moharana 
*
*/

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;



/*@JsonDeserialize(using=TradeDeserializer.class)*/

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.DEFAULT)
/*@JsonIgnoreProperties(ignoreUnknown=true) */
public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String customer;

	private String ccyPair;

	private String direction;
	/*
	@JsonDeserialize(using = FloatingNumberDeserialzer.class)*/
	private float	 amount1;

	private float amount2;

	private String legalEntity;

	private float rate;

	private Date tradeDate;

	private String trader;

	private String type;

	private Date valueDate;
	
	private Date excerciseDate;
	
	private Date expiryDate;
	
	private Date deliveryDate;
	
	private Date premiumDate;

	public Trade() {
		super();
	}

	public Trade(String customer, String ccyPair, String direction, float amount1, float amount2, String legalEntity,
			float rate, Date tradeDate, String trader, String type, Date valueDate,Date excerciseDate,Date expiryDate,Date deliveryDate,Date premiumDate) {
		super();
		this.customer = customer;
		this.ccyPair = ccyPair;
		this.direction = direction;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.legalEntity = legalEntity;
		this.rate = rate;
		this.tradeDate = tradeDate;
		this.trader = trader;
		this.type = type;
		this.valueDate = valueDate;
		this.excerciseDate = excerciseDate;
		this.excerciseDate = expiryDate;
		this.deliveryDate = deliveryDate;
		this.premiumDate = premiumDate;
		
	}
	


	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCcyPair() {
		return ccyPair;
	}

	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public float getAmount1() {
		return amount1;
	}

	public void setAmount1(float amount1)  {
		this.amount1 = amount1;
	}

	public float getAmount2() {
		return amount2;
	}

	public void setAmount2(float amount2) {
		this.amount2 = amount2;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	

	public Date getExcerciseDate() {
		return excerciseDate;
	}

	public void setExcerciseDate(Date excerciseDate) {
		this.excerciseDate = excerciseDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getPremiumDate() {
		return premiumDate;
	}

	public void setPremiumDate(Date premiumDate) {
		this.premiumDate = premiumDate;
	}

	@Override
	public String toString() {
		return "Trade [customer=" + customer + ", ccyPair=" + ccyPair + ", direction=" + direction + ", amount1="
				+ amount1 + ", amount2=" + amount2 + ", legalEntity=" + legalEntity + ", rate=" + rate + ", tradeDate="
				+ tradeDate + ", trader=" + trader + ", type=" + type + ", valueDate=" + valueDate + ", excerciseDate="
				+ excerciseDate + ", expiryDate=" + expiryDate + ", deliveryDate=" + deliveryDate + ", premiumDate="
				+ premiumDate + "]";
	}

	


	

	

	
	
}
