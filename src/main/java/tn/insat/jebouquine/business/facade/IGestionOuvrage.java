package tn.insat.jebouquine.business.facade;

import java.util.List;

import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Editeur;
import tn.insat.jebouquine.data.entity.Ouvrage;

public interface IGestionOuvrage {
	
	public void addAuteur(Auteur a);
	public void updateAuteur(Auteur a);
	public Auteur getAutuerById(int id);
	public List<Auteur> listAuteursByNomPrenom(String nom,String prenom);
	public List<Auteur> listAuteursByNationnalite(String nationnalite);
	public List<Auteur> listAuteurs();
	public void deleteAuteur(Auteur a);
	
	public void addEditeur(Editeur e);
	public void updateEditeur(Editeur e);
	public Editeur getEditeurById(int id);
	public Editeur getEditeurByNom(String nom);
	public List<Editeur> listEditeurs();
	public void deleteEditeur(Editeur e);
	
	public void addCategorie(Categorie c);
	public void updateCategorie(Categorie c);
	public Categorie getCategorieById(int id);
	public List<Categorie> listCategories();
	public void deleteCategorie(Categorie c);
	
	public void addOuvrage(Ouvrage o);
	public void updateOuvrage(Ouvrage o);
	public Ouvrage getOuvrageById(int id);
	public Ouvrage getOuvrageByTitre(String titre);
	public Ouvrage getOuvrageByISBN(String isbn);
	public Ouvrage getOuvrageByDateParution(String date);
	public List<Ouvrage> listOuvragesByMotCle(String motCle);
	public List<Ouvrage> listOuvragesByAuteur(Auteur a);
	public List<Ouvrage> listOuvragesByCategorie(Categorie c);
	public List<Ouvrage> listOuvragesByEditeur(Editeur e);
	public List<Ouvrage> listOuvrages();
	public void deleteOuvrage(Ouvrage o);
	
	
}
