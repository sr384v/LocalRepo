package com.cs.trade.tradeprocessingsystem.service;

/**
 * @author SoumyaRanjan Moharana
 *
 */

import com.cs.trade.tradeprocessingsystem.exception.TradeNotValid;
import com.cs.trade.tradeprocessingsystem.model.Trade;


public interface TradeValidatorService {
	
	public boolean currencyValidate(String ccyPair);
	
	public void genericValidation(Trade tcn) throws TradeNotValid;

}
