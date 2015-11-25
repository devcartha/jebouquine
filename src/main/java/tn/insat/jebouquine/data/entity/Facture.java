package tn.insat.jebouquine.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factures")
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dateFacturation;
	private String etatFacture;
	private double total;
	
	@OneToOne
	private Commande commande;
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(String dateFacturation, String etatFacture, double total, Commande commande) {
		super();
		this.dateFacturation = dateFacturation;
		this.etatFacture = etatFacture;
		this.total = total;
		this.commande = commande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(String dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public String getEtatFacture() {
		return etatFacture;
	}

	public void setEtatFacture(String etatFacture) {
		this.etatFacture = etatFacture;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", commande=" + commande + "]";
	}
	
	

}
