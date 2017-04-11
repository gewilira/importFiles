package org.giabiera.importFx.repositories;

import org.giabiera.importFx.entities.FileLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileLogRepository extends CrudRepository<FileLog, String>{

}
