package com.example.demo.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class FormulaireEmprunt {

	@Id
	private long idFormulaire;
	@Column
	private String typeFormulaire;
	@Column
	private String nomFormulaire;
	@Column
	private int quantite;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateEmprunt;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateRetour;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "employe")
	private Employe employe;
	@Column
	private boolean demandeValidee;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "fourniture")
	private Fourniture fourniture;

	public long getIdFormulaire() {
		return idFormulaire;
	}

	public void setIdFormulaire(long idFormulaire) {
		this.idFormulaire = idFormulaire;
	}

	public String getTypeFormulaire() {
		return typeFormulaire;
	}

	public void setTypeFormulaire(String typeFormulaire) {
		this.typeFormulaire = typeFormulaire;
	}

	public String getNomFormulaire() {
		return nomFormulaire;
	}

	public void setNomFormulaire(String nomFormulaire) {
		this.nomFormulaire = nomFormulaire;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public boolean isDemandeValidee() {
		return demandeValidee;
	}

	public void setDemandeValidee(boolean demandeValidee) {
		this.demandeValidee = demandeValidee;
	}

	public Fourniture getFourniture() {
		return fourniture;
	}

	public void setFourniture(Fourniture fourniture) {
		this.fourniture = fourniture;
	}

	public FormulaireEmprunt() {
		super();
	}

	public FormulaireEmprunt(long idFormulaire, String typeFormulaire, String nomFormulaire, Date dateEmprunt,
			Date dateRetour, Fourniture fourniture) {
		super();
		this.idFormulaire = idFormulaire;
		this.typeFormulaire = typeFormulaire;
		this.nomFormulaire = nomFormulaire;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.fourniture = fourniture;
	}

	public FormulaireEmprunt(long idFormulaire, String typeFormulaire, String nomFormulaire, Date dateEmprunt,
			Date dateRetour, Employe employe, boolean demandeValidee, Fourniture fourniture) {
		super();
		this.idFormulaire = idFormulaire;
		this.typeFormulaire = typeFormulaire;
		this.nomFormulaire = nomFormulaire;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.employe = employe;
		this.demandeValidee = demandeValidee;
		this.fourniture = fourniture;
	}

	
	public FormulaireEmprunt(long idFormulaire, String typeFormulaire, String nomFormulaire, int quantite,
			Date dateEmprunt, Employe employe, boolean demandeValidee, Fourniture fourniture) {
		super();
		this.idFormulaire = idFormulaire;
		this.typeFormulaire = typeFormulaire;
		this.nomFormulaire = nomFormulaire;
		this.quantite = quantite;
		this.dateEmprunt = dateEmprunt;
		this.employe = employe;
		this.demandeValidee = demandeValidee;
		this.fourniture = fourniture;
	}

	@Override
	public String toString() {
		return "FormulaireEmprunt [idFormulaire=" + idFormulaire + ", typeFormulaire=" + typeFormulaire
				+ ", nomFormulaire=" + nomFormulaire + ", dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour
				+ ", fourniture=" + fourniture + "]";
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
