package org.giabiera.importFx.repositories;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.giabiera.importFx.ImportFilesApplication;
import org.giabiera.importFx.entities.AccumulatedData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes=ImportFilesApplication.class)
public class AccumulatedDataTest {

	@Autowired
	private AccumulatedDataRepository repository;

	
	@Test
	public void save_01() throws Exception {
		repository.save(new AccumulatedData("AED", 100));
		assertEquals(1, repository.count());
	}

	@Test
	public void save_02() throws Exception {
		repository.save(new AccumulatedData("AED", 100));
		repository.save(new AccumulatedData("PHP", 300));
		assertEquals(2, repository.count());
	}

	@Test
	public void save_03() throws Exception {

		List<AccumulatedData> AccumulativeDatas = new ArrayList<AccumulatedData>();
		AccumulativeDatas.add(new AccumulatedData("AED", 100));
		AccumulativeDatas.add(new AccumulatedData("PHP", 200));
		AccumulativeDatas.add(new AccumulatedData("USD", 150));

		repository.save(AccumulativeDatas);
		assertEquals(3, repository.count());
	}
	
	@Test
	public void find_01() throws Exception {
		repository.save(new AccumulatedData("AED", 100));
	
		AccumulatedData data = repository.findOne("AED");
		assertNotNull(data);
		assertTrue( data.getCountOfDeals().equals(100));
	}
	
	@Test
	public void find_02() throws Exception {
		repository.save(new AccumulatedData("AED", 100));
	
		AccumulatedData data = repository.findOne("USD");
		assertNull(data);
		
	}
	

	@Test
	public void delete_01() throws Exception {
		repository.save(new AccumulatedData("AED", 100));

		repository.delete(repository.findOne("AED"));
		
		assertEquals(0, repository.count());
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void delete_02() throws Exception {
		repository.delete("Invalid");

	}
}
