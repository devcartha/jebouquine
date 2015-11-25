package tn.insat.jebouquine.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "ouvrages")
public class Ouvrage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String ISBN;
	private String dateParution;
	private String image;
	private int quantiteDispo;
	private int quantiteVendus;

	@ManyToOne
	private Categorie categorie;
	@ManyToMany
	private List<Auteur> auteurs;

	@ManyToOne
	private Editeur editeur;

	public Ouvrage() {
		super();
	}

	public Ouvrage(String titre, String iSBN, String dateParution, String image, int quantiteDispo, int quantiteVendus,
			Categorie categorie, List<Auteur> auteurs, Editeur editeur) {
		super();
		this.titre = titre;
		ISBN = iSBN;
		this.dateParution = dateParution;
		this.image = image;
		this.quantiteDispo = quantiteDispo;
		this.quantiteVendus = quantiteVendus;
		this.categorie = categorie;
		this.auteurs = auteurs;
		this.editeur = editeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getDateParution() {
		return dateParution;
	}

	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantiteDispo() {
		return quantiteDispo;
	}

	public void setQuantiteDispo(int quantiteDispo) {
		this.quantiteDispo = quantiteDispo;
	}

	public int getQuantiteVendus() {
		return quantiteVendus;
	}

	public void setQuantiteVendus(int quantiteVendus) {
		this.quantiteVendus = quantiteVendus;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	@Override
	public String toString() {
		return "Ouvrage [id=" + id + ", titre=" + titre + ", ISBN=" + ISBN + ", dateParution=" + dateParution
				+ ", image=" + image + ", quantiteDispo=" + quantiteDispo + ", quantiteVendus=" + quantiteVendus
				+ ", categorie=" + categorie + ", auteurs=" + auteurs + ", editeur=" + editeur + "]";
	}

	
}
