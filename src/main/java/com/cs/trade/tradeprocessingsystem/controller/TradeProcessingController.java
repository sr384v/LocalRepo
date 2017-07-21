package com.cs.trade.tradeprocessingsystem.controller;


/**
 * @author SoumyaRanjan Moharana
 *
 */


import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.cs.trade.tradeprocessingsystem.exception.TradeNotValid;
import com.cs.trade.tradeprocessingsystem.model.Trade;
import com.cs.trade.tradeprocessingsystem.service.TradeValidatorService;
import com.cs.trade.tradeprocessingsystem.service.impl.TradeValidatorServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;






@Path("/trade")
public class TradeProcessingController {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	Logger log = Logger.getLogger(TradeProcessingController.class);
	TradeValidatorService tradeValidatorService;
	Trade trade;

	@POST
	@Path("/validateTrades")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  validateTradesPost(String rawTrade) throws JsonParseException, JsonMappingException, IOException{
			tradeValidatorService = new TradeValidatorServiceImpl();
			objectMapper = new ObjectMapper();
			
			try {
				trade = objectMapper.readValue(rawTrade, Trade.class);
				
				//Now we are validating if our trade object is having proper data
					try {
						if(trade!=null) {
							tradeValidatorService.genericValidation(trade);
						}else {
							log.info("Trade  information is null");
						}
						
					}catch(TradeNotValid e) {
						log.error("Trade is not valid");
						return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
					}
			return Response.status(200).entity(trade).build();
				
			}catch(Exception e) {
				log.error("Bad Request, JSON is not valid");
				return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			}
			
		
	}
	
	

}
