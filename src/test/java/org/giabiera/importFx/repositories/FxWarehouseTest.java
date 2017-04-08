package org.giabiera.importFx.repositories;

import org.giabiera.importFx.ImportFilesApplication;
import org.giabiera.importFx.entities.FxWarehouse;
import org.giabiera.importFx.repositories.FxWarehouseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=ImportFilesApplication.class)
public class FxWarehouseTest {
	
	@Autowired
    private FxWarehouseRepository repository;

    @Test
    public void save_01() throws Exception {
    	repository.save(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
        assertEquals(1, repository.count());
    }
    
    @Test
    public void save_02() throws Exception {
    	repository.save(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
    	repository.save(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
        assertEquals(2, repository.count());
    }
    
    @Test
    public void save_03() throws Exception {
    	
    	List<FxWarehouse> fxRecords = new ArrayList<FxWarehouse>();
    	fxRecords.add(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
    	fxRecords.add(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
    	fxRecords.add(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
    
    	repository.save(fxRecords);
        assertEquals(3, repository.count());
    }
    
    @Test
    public void delete_01() throws Exception {
    	repository.save(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
    	
    	for(FxWarehouse fxRecord : repository.findAll()){
    		repository.delete(repository.findOne(fxRecord.getId()));
    	}
    	 	
        assertEquals(0, repository.count());
    }
    
    @Test(expected=EmptyResultDataAccessException.class)
    public void delete_02() throws Exception {
    	repository.delete(new Long(1));
    	
    }
    
    @Test
    public void find_01() throws Exception {
    	List<FxWarehouse> fxRecords = new ArrayList<FxWarehouse>();
    	fxRecords.add(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
    	fxRecords.add(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(7000)));
    	fxRecords.add(new FxWarehouse(new Date(), "AED", "USD", new BigDecimal(8000)));
    
    	repository.save(fxRecords);
    	int count = 0;
    	for(FxWarehouse fxRecord : repository.findAll()){
    		if(fxRecord.getAmount().equals(new BigDecimal(8000))){
    		count++;
    		}
    	}
    	
    	assertEquals(2, count);
    }
    
    @Test()
    public void find_02() throws Exception {
    	assertNull(repository.findOne(new Long(1)));
    }

}
