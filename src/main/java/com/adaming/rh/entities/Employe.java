package com.adaming.rh.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Employe {
	@Id
	private long idEmploye;
	@Column
	private String nomEmploye;
	@Column
	private String prenomEmploye;
	@Column
	private String sexeEmploye;
	@Column
	private String adresseEmploye;
	@Column
	private String statutEmploye;
	@Column
	private double salaireEmploye;
	@Column
	private String typeContratEmploye;
	@Column
	private Date dateEntreeEmploye;
	@Column
	private Date dateSortieEmploye;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "employe", orphanRemoval = true)
	private List<DocumentRH> document = new ArrayList<>();

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "employe", orphanRemoval = true)
	private List<FormulaireEmprunt> formulaire = new ArrayList<>();

	@ManyToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Fourniture> fourniture;

	public long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getSexeEmploye() {
		return sexeEmploye;
	}

	public void setSexeEmploye(String sexeEmploye) {
		this.sexeEmploye = sexeEmploye;
	}

	public String getAdresseEmploye() {
		return adresseEmploye;
	}

	public void setAdresseEmploye(String adresseEmploye) {
		this.adresseEmploye = adresseEmploye;
	}

	public String getStatutEmploye() {
		return statutEmploye;
	}

	public void setStatutEmploye(String statutEmploye) {
		this.statutEmploye = statutEmploye;
	}

	public double getSalaireEmploye() {
		return salaireEmploye;
	}

	public void setSalaireEmploye(double salaireEmploye) {
		this.salaireEmploye = salaireEmploye;
	}

	public String getTypeContratEmploye() {
		return typeContratEmploye;
	}

	public void setTypeContratEmploye(String typeContratEmploye) {
		this.typeContratEmploye = typeContratEmploye;
	}

	public Date getDateEntreeEmploye() {
		return dateEntreeEmploye;
	}

	public void setDateEntreeEmploye(Date dateEntreeEmploye) {
		this.dateEntreeEmploye = dateEntreeEmploye;
	}

	public Date getDateSortieEmploye() {
		return dateSortieEmploye;
	}

	public void setDateSortieEmploye(Date dateSortieEmploye) {
		this.dateSortieEmploye = dateSortieEmploye;
	}

	public List<DocumentRH> getDocument() {
		return document;
	}

	public void setDocument(List<DocumentRH> document) {
		this.document = document;
	}

	public List<FormulaireEmprunt> getFormulaire() {
		return formulaire;
	}

	public void setFormulaire(List<FormulaireEmprunt> formulaire) {
		this.formulaire = formulaire;
	}

	public List<Fourniture> getFourniture() {
		return fourniture;
	}

	public void setFourniture(List<Fourniture> fourniture) {
		this.fourniture = fourniture;
	}

	public Employe() {
		super();
	}

	public Employe(long idEmploye, String nomEmploye, String prenomEmploye, String sexeEmploye, String adresseEmploye,
			String statutEmploye, double salaireEmploye, String typeContratEmploye, Date dateEntreeEmploye,
			Date dateSortieEmploye, List<DocumentRH> document) {
		super();
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.sexeEmploye = sexeEmploye;
		this.adresseEmploye = adresseEmploye;
		this.statutEmploye = statutEmploye;
		this.salaireEmploye = salaireEmploye;
		this.typeContratEmploye = typeContratEmploye;
		this.dateEntreeEmploye = dateEntreeEmploye;
		this.dateSortieEmploye = dateSortieEmploye;
		this.document = document;
	}

	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", sexeEmploye=" + sexeEmploye + ", adresseEmploye=" + adresseEmploye + ", statutEmploye="
				+ statutEmploye + ", salaireEmploye=" + salaireEmploye + ", typeContratEmploye=" + typeContratEmploye
				+ ", dateEntreeEmploye=" + dateEntreeEmploye + ", dateSortieEmploye=" + dateSortieEmploye
				+ ", document=" + document + ", formulaire=" + formulaire + ", fourniture=" + fourniture + "]";
	}

}