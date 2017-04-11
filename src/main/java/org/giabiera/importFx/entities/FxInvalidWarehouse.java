package org.giabiera.importFx.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FxInvalidWarehouse {

	private Long id;
	private String invalidRecord;
	private String fileName;	
	
	public FxInvalidWarehouse(){}
	
	public FxInvalidWarehouse(String invalidRecord, String fileName){
		this.invalidRecord = invalidRecord;
		this.fileName = fileName;
	}
	
	
	@Id
	public String getInvalidRecord() {
		return invalidRecord;
	}
	public void setInvalidRecord(String invalidRecord) {
		this.invalidRecord = invalidRecord;
	}
	
	@Column(nullable=false)
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
