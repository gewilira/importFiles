package org.giabiera.importFx.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fx_invalid_warehouse")
public class FxInvalidWarehouse {
	
	private Long id;
	private Date dateCreated;
	private String invalidRecord;
	private String cause;
	private String fileName;
	
	public FxInvalidWarehouse() {
		
	}
	
	public FxInvalidWarehouse(Date dateCreated, String invalidRecord, String cause, String fileName ) {
		this.dateCreated = dateCreated;
		this.setInvalidRecord(invalidRecord);
		this.cause = cause;
		this.fileName = fileName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="dateCreated", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	@Column(name="cause", nullable=false)
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
	@Column(name="fileName", nullable=false)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name="invalidRecord", nullable=false)
	public String getInvalidRecord() {
		return invalidRecord;
	}

	public void setInvalidRecord(String invalidRecord) {
		this.invalidRecord = invalidRecord;
	}

}
