package com.adaming.rh.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.adaming.rh.entities.Employe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class DocumentRH {
	@Id
	private long idDocument;
	@Column
	private String typeDocument;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateEditionDocument;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "employe")
	private Employe employe;

	public long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(long idDocument) {
		this.idDocument = idDocument;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public Date getDateEditionDocument() {
		return dateEditionDocument;
	}

	public void setDateEditionDocument(Date dateEditionDocument) {
		this.dateEditionDocument = dateEditionDocument;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public DocumentRH() {
		super();
	}

	public DocumentRH(long idDocument, String typeDocument, Date dateEditionDocument, Employe employe) {
		super();
		this.idDocument = idDocument;
		this.typeDocument = typeDocument;
		this.dateEditionDocument = dateEditionDocument;
		this.employe = employe;
	}
	
	

}
