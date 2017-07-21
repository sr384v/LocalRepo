package com.cs.trade.tradeprocessingsystem.util;

/**
 * @author SoumyaRanjan Moharana
 *
 */

import java.util.Currency;

import org.apache.log4j.Logger;


public class CuurencyValidator {
	
	public static boolean  validateCurrencyCode(String currencyCode) {
	Logger log = Logger.getLogger(CuurencyValidator.class);
		try {
            Currency.getInstance(currencyCode.trim().toUpperCase());
            log.trace("Currency is valid");
            return true;
        } catch (IllegalArgumentException e) {
        	log.trace("Not a valid currency");
        	return false;
        }
		
	}
}
