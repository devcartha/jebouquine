package tn.insat.jebouquine.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lignesCommande")
public class LigneCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double prix;
	private int quantite;

	@ManyToOne
	private Ouvrage ouvrage;

	@ManyToOne
	private Commande commande;

	public LigneCommande() {
		super();
	}

	public LigneCommande(double prix, int quantite, Ouvrage ouvrage) {
		super();
		this.prix = prix;
		this.quantite = quantite;
		this.ouvrage = ouvrage;
	}

	public LigneCommande(double prix, int quantite, Ouvrage ouvrage, Commande commande) {
		super();
		this.prix = prix;
		this.quantite = quantite;
		this.ouvrage = ouvrage;
		this.commande = commande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", prix=" + prix + ", quantite=" + quantite + ", ouvrage=" + ouvrage
				+ ", commande=" + commande + "]";
	}

	
}
