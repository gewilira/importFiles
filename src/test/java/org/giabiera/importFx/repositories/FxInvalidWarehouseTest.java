package org.giabiera.importFx.repositories;

import org.giabiera.importFx.ImportFilesApplication;
import org.giabiera.importFx.entities.FxInvalidWarehouse;
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
public class FxInvalidWarehouseTest {
	
	@Autowired
    private FxInvalidWarehouseRepository repository;

	@Test
	public void save_01() throws Exception {
		repository.save(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));
		assertEquals(1, repository.count());
	}

	@Test
	public void save_02() throws Exception {
		repository.save(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));
		repository.save(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));
		assertEquals(2, repository.count());
	}

	@Test
	public void save_03() throws Exception {

		List<FxInvalidWarehouse> Fxinvalids = new ArrayList<FxInvalidWarehouse>();
		Fxinvalids.add(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));

		repository.save(Fxinvalids);
		assertEquals(3, repository.count());
	}

	@Test
	public void delete_01() throws Exception {
		repository.save(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));

		for (FxInvalidWarehouse Fxinvalid : repository.findAll()) {
			repository.delete(repository.findOne(Fxinvalid.getId()));
		}

		assertEquals(0, repository.count());
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void delete_02() throws Exception {
		repository.delete(new Long(1));

	}

	@Test
	public void find_01() throws Exception {
		List<FxInvalidWarehouse> Fxinvalids = new ArrayList<FxInvalidWarehouse>();
		Fxinvalids.add(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid amount format", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse(new Date(), "Invalid Record", "Invalid currency", "file path"));

		repository.save(Fxinvalids);
		int count = 0;
		for (FxInvalidWarehouse Fxinvalid : repository.findAll()) {
			if (Fxinvalid.getCause().equals("Invalid currency")) {
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
