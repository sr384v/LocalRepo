package com.cs.trade.tradeprocessingsystem.service.impl;

/**
 * @author SoumyaRanjan Moharana
 *
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.cs.trade.tradeprocessingsystem.constants.DAY;
import com.cs.trade.tradeprocessingsystem.exception.TradeNotValid;
import com.cs.trade.tradeprocessingsystem.model.Trade;
import com.cs.trade.tradeprocessingsystem.service.TradeValidatorService;
import com.cs.trade.tradeprocessingsystem.util.CuurencyValidator;




public class TradeValidatorServiceImpl implements TradeValidatorService {
	
	Logger log = Logger.getLogger(TradeValidatorService.class);
	Calendar tradeCalender = Calendar.getInstance();
		
	@Override
	public boolean currencyValidate(String ccyPair) {
		
		return false;
	}

	@Override
	public void genericValidation(Trade tcn) throws TradeNotValid {
		
		
		StringBuilder errorMessages = new StringBuilder();
		Properties tradeProp =new Properties(); 
		
		tradeCalender.setTime(tcn.getValueDate());
		log.info("Trade Validation in progress");
		if(DAY.SATURDAY.equals(tradeCalender.get(Calendar.DAY_OF_WEEK)) || DAY.SUNDAY.equals(tradeCalender.get(Calendar.DAY_OF_WEEK))){
			log.trace("Value Date cannot be a holiday");
			errorMessages.append(" [Value Date cannot be a holiday] ");
		}
		
		if(tcn.getValueDate().before(tcn.getTradeDate())) {
			log.trace("Value Date cannot be before Trade Date");
			errorMessages.append(" [Value Date cannot be before Trade Date] ");
		}
		
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("trade.properties");
		try {
			tradeProp.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		if(!Arrays.asList(tradeProp.getProperty("counterparty").split(",")).contains(tcn.getCustomer())) {
			log.trace("Not a valid trade counterparty type");
			errorMessages.append(" [Not a valid trade counterparty type] ");
		}
		try {
			//Validate Currency Pair
			String ccyNumerator = tcn.getCcyPair().substring(0, 3);
			String ccyDenominator = tcn.getCcyPair().substring(3, tcn.getCcyPair().length()); 
		if(!CuurencyValidator.validateCurrencyCode(ccyNumerator) || !CuurencyValidator.validateCurrencyCode(ccyDenominator)) {
			log.trace("Currency pair is not valid");
			errorMessages.append(" [Currency pair is not valid] ");
		}
		if(tcn.getType().equalsIgnoreCase("OPTION")) {
			//Option related validations
		if(tcn.getDeliveryDate()!=null && tcn.getExcerciseDate().before(tcn.getExpiryDate()) || tcn.getDeliveryDate()!=null 
				&& tcn.getExcerciseDate().before(tcn.getDeliveryDate())) {
			log.trace("expiry date and premium date shall be before delivery date");
			errorMessages.append(" [expiry date and premium date shall be before delivery date] ");
		}
			if(tcn.getExcerciseDate()!=null && tcn.getExcerciseDate().before(tcn.getTradeDate())) {
				log.trace("trade date  before the expiry date");
				errorMessages.append(" [trade date  before the expiry date] ");
			}
		}
		}catch(StringIndexOutOfBoundsException	 e) {
			log.trace("Currency pair is not valid");
			errorMessages.append(" [Currency pair is not valid] ");
		}
		if(errorMessages.length()>0) {
			throw new TradeNotValid(errorMessages.toString());
		}
	}

	
	
	

}
