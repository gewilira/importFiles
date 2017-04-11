package org.giabiera.importFx.service;

import java.util.Date;

import org.giabiera.importFx.entities.FileLog;
import org.giabiera.importFx.repositories.FileLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileLogService {
	
	private static final Logger log = LoggerFactory.getLogger(FxrecordService.class);
	
	@Autowired
	private FileLogRepository fileLogRepository;
	
	public boolean addFileLog(String fileName, Date dateImported){
		if(fileLogRepository.findOne(fileName) == null) {
			fileLogRepository.save(new FileLog(fileName, dateImported));
			return true;
		}
		return false;
	}

}
