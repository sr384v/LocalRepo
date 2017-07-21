package com.cs.trade.tradeprocessingsystem.exception;

/**
 * @author SoumyaRanjan Moharana
 *
 */

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class TradeNotValid extends Exception implements
ExceptionMapper<TradeNotValid>  {

	private static final long serialVersionUID = 1L;
	
	public TradeNotValid(String msg)  {
		
		super(msg);
	}

	@Override
	public Response toResponse(TradeNotValid e) {
		
		return Response.status(404).entity(e.getMessage())
                .type("text/plain").build();
	}
	
	

}
