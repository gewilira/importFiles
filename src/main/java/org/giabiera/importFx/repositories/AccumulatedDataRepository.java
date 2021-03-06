package org.giabiera.importFx.repositories;

import org.giabiera.importFx.entities.AccumulatedData;
import org.giabiera.importFx.entities.FxWarehouse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccumulatedDataRepository extends CrudRepository<AccumulatedData, String> {
	
}
