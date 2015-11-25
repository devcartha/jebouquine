package tn.insat.jebouquine.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commandes")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dateCommande;
	private String modePaiement;
	private double fraisLivraison;
	private String adresseLivraison;
	private String etatCommande;

	@ManyToOne
	private Client client;

	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> lignesCommande;

	@OneToOne
	private Facture facture;

	public Commande() {
		super();
	}

	public Commande(String dateCommande, String modePaiement, double fraisLivraison, String adresseLivraison,
			String etatCommande, Client client, List<LigneCommande> lignesCommande, Facture facture) {
		super();
		this.dateCommande = dateCommande;
		this.modePaiement = modePaiement;
		this.fraisLivraison = fraisLivraison;
		this.adresseLivraison = adresseLivraison;
		this.etatCommande = etatCommande;
		this.client = client;
		this.lignesCommande = lignesCommande;
		this.facture = facture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommmande) {
		this.dateCommande = dateCommmande;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public double getFraisLivraison() {
		return fraisLivraison;
	}

	public void setFraisLivraison(double fraisLivraison) {
		this.fraisLivraison = fraisLivraison;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public String getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(String etatCommande) {
		this.etatCommande = etatCommande;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCommande=" + dateCommande + ", modePaiement=" + modePaiement
				+ ", fraisLivraison=" + fraisLivraison + ", adresseLivraison=" + adresseLivraison
				+ ", etatCommande=" + etatCommande + ", client=" + client + ", lignesCommande=" + lignesCommande
				+ ", facture=" + facture + "]";
	}

}
