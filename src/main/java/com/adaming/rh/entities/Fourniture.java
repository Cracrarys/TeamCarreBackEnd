package com.adaming.rh.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Fourniture {
	@Id
	private long idFourniture;
	@Column
	private String typeFourniture;
	@Column
	private String nomFourniture;
	@Column
	private double quantiteDisponible;
	@Column
	private double quantiteTotale;
	@Column
	private boolean consommable;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "fourniture", orphanRemoval = true)
	private List<FormulaireEmprunt> formulaire = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "affectations", joinColumns = @JoinColumn(name = "fourniture"), inverseJoinColumns = @JoinColumn(name = "employe"))
	private List<Employe> employe;

	public long getIdFourniture() {
		return idFourniture;
	}

	public void setIdFourniture(long idFourniture) {
		this.idFourniture = idFourniture;
	}

	public String getTypeFourniture() {
		return typeFourniture;
	}

	public void setTypeFourniture(String typeFourniture) {
		this.typeFourniture = typeFourniture;
	}

	public String getNomFourniture() {
		return nomFourniture;
	}

	public void setNomFourniture(String nomFourniture) {
		this.nomFourniture = nomFourniture;
	}

	public double getQuantiteDisponible() {
		return quantiteDisponible;
	}

	public void setQuantiteDisponible(double quantiteDisponible) {
		this.quantiteDisponible = quantiteDisponible;
	}

	public double getQuantiteTotale() {
		return quantiteTotale;
	}

	public void setQuantiteTotale(double quantiteTotale) {
		this.quantiteTotale = quantiteTotale;
	}

	public boolean isConsommable() {
		return consommable;
	}

	public void setConsommable(boolean consommable) {
		this.consommable = consommable;
	}

	public List<FormulaireEmprunt> getFormulaire() {
		return formulaire;
	}

	public void setFormulaire(List<FormulaireEmprunt> formulaire) {
		this.formulaire = formulaire;
	}

	public List<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}

	public Fourniture() {
		super();
	}

	public Fourniture(long idFourniture, String typeFourniture, String nomFourniture, double quantiteDisponible,
			double quantiteTotale, boolean consommable, List<FormulaireEmprunt> formulaire, List<Employe> employe) {
		super();
		this.idFourniture = idFourniture;
		this.typeFourniture = typeFourniture;
		this.nomFourniture = nomFourniture;
		this.quantiteDisponible = quantiteDisponible;
		this.quantiteTotale = quantiteTotale;
		this.consommable = consommable;
		this.formulaire = formulaire;
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Fourniture [idFourniture=" + idFourniture + ", typeFourniture=" + typeFourniture + ", nomFourniture="
				+ nomFourniture + ", quantiteDisponible=" + quantiteDisponible + ", quantiteTotale=" + quantiteTotale
				+ ", consommable=" + consommable + ", formulaire=" + formulaire + ", employe=" + employe + "]";
	}

}
