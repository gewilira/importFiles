package org.giabiera.importFx.repositories;

import org.giabiera.importFx.ImportFilesApplication;
import org.giabiera.importFx.entities.FxInvalidWarehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
		repository.save(new FxInvalidWarehouse("Invalid Record", "file path"));
		assertEquals(1, repository.count());
	}

	@Test
	public void save_02() throws Exception {
		repository.save(new FxInvalidWarehouse("Invalid Record", "file path"));
		repository.save(new FxInvalidWarehouse("Invalid Record1", "file path"));
		repository.save(new FxInvalidWarehouse("Invalid Record2", "file path"));
		assertEquals(3, repository.count());
	}

	@Test
	public void save_03() throws Exception {

		List<FxInvalidWarehouse> Fxinvalids = new ArrayList<FxInvalidWarehouse>();
		Fxinvalids.add(new FxInvalidWarehouse("Invalid Record1", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse("Invalid Record2", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse("Invalid Record3", "file path"));

		repository.save(Fxinvalids);
		assertEquals(3, repository.count());
	}

	@Test
	public void delete_01() throws Exception {
		repository.save(new FxInvalidWarehouse("Invalid Record", "file path"));
		repository.delete(repository.findOne("Invalid Record"));
		assertEquals(0, repository.count());
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void delete_02() throws Exception {
		repository.delete("Invalid");

	}

	@Test
	public void find_01() throws Exception {
		List<FxInvalidWarehouse> Fxinvalids = new ArrayList<FxInvalidWarehouse>();
		Fxinvalids.add(new FxInvalidWarehouse("Invalid Record1", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse("Invalid Record2", "file path"));
		Fxinvalids.add(new FxInvalidWarehouse("Invalid Record3", "file path"));

		repository.save(Fxinvalids);
		int count = 0;
		for (FxInvalidWarehouse Fxinvalid : repository.findAll()) {
			if (Fxinvalid.getInvalidRecord().equals("Invalid Record")) {
				count++;
			}
		}

		assertEquals(3, count);
	}

	@Test()
	public void find_02() throws Exception {
		assertNull(repository.findOne("Invalid"));
	}

}
