package org.giabiera.importFx.service;

import org.giabiera.importFx.entities.AccumulatedData;
import org.giabiera.importFx.repositories.AccumulatedDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccumulatedDataService {
	
	private static final Logger log = LoggerFactory.getLogger(AccumulatedDataService.class);
	
	@Autowired
	private AccumulatedDataRepository accumulatedDataRepository;
	
	public AccumulatedData getAccumulatedData(String currency){
		AccumulatedData data = accumulatedDataRepository.findOne(currency);
		
		if(data == null) {
			return new AccumulatedData(currency, 0);
		} else {
			data.incrementCountOfDeals();
			return data;
		}
	}

}
