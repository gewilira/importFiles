package org.giabiera.importFx.repositories;

import org.giabiera.importFx.entities.FxInvalidWarehouse;
import org.giabiera.importFx.entities.FxWarehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxInvalidWarehouseRepository extends CrudRepository<FxInvalidWarehouse, String> {

}
