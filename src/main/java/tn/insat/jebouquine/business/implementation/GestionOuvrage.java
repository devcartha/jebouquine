package tn.insat.jebouquine.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import tn.insat.jebouquine.business.facade.*;
import tn.insat.jebouquine.data.access.facade.*;
import tn.insat.jebouquine.data.entity.*;

@Service("gestionOuvrage")
@Transactional
public class GestionOuvrage implements IGestionOuvrage{

	@Autowired
	@Qualifier("ouvrageRepository")
	private IOuvrageRepository ouvrageRepo;
	
	
	@Override
	public void addAuteur(Auteur a) {
		this.ouvrageRepo.addAuteur(a);
	}

	@Override
	public void updateAuteur(Auteur a) {
		this.ouvrageRepo.updateAuteur(a);
	}

	@Override
	public Auteur getAutuerById(int id) {
		return this.ouvrageRepo.getAutuerById(id);
	}

	@Override
	public List<Auteur> listAuteursByNomPrenom(String nom, String prenom) {
		return this.ouvrageRepo.listAuteursByNomPrenom(nom, prenom);
	}

	@Override
	public List<Auteur> listAuteursByNationnalite(String nationnalite) {
		return this.ouvrageRepo.listAuteursByNationnalite(nationnalite);
	}

	@Override
	public List<Auteur> listAuteurs() {
		return this.ouvrageRepo.listAuteurs();
	}

	@Override
	public void deleteAuteur(Auteur a) {
		this.ouvrageRepo.deleteAuteur(a);
	}

	@Override
	public void addEditeur(Editeur e) {
		this.ouvrageRepo.addEditeur(e);
	}

	@Override
	public void updateEditeur(Editeur e) {
		this.ouvrageRepo.updateEditeur(e);
	}

	@Override
	public Editeur getEditeurById(int id) {
		return this.ouvrageRepo.getEditeurById(id);
	}

	@Override
	public Editeur getEditeurByNom(String nom) {
		return this.ouvrageRepo.getEditeurByNom(nom);
	}

	@Override
	public List<Editeur> listEditeurs() {
		return this.ouvrageRepo.listEditeurs();
	}

	@Override
	public void deleteEditeur(Editeur e) {
		this.ouvrageRepo.deleteEditeur(e);
	}

	@Override
	public void addCategorie(Categorie c) {
		this.ouvrageRepo.addCategorie(c);
	}

	@Override
	public void updateCategorie(Categorie c) {
		this.ouvrageRepo.updateCategorie(c);
	}

	@Override
	public Categorie getCategorieById(int id) {
		return this.ouvrageRepo.getCategorieById(id);
	}

	@Override
	public List<Categorie> listCategories() {
		return this.ouvrageRepo.listCategories();
	}

	@Override
	public void deleteCategorie(Categorie c) {
		this.ouvrageRepo.deleteCategorie(c);
	}

	@Override
	public void addOuvrage(Ouvrage o) {
		this.ouvrageRepo.addOuvrage(o);
	}

	@Override
	public void updateOuvrage(Ouvrage o) {
		this.ouvrageRepo.updateOuvrage(o);
	}

	/* le transaction manager associe une session à chaque methode transactionnel 
		utilisant sessionFactory.getCurrentSession();
	*/
	@Override
	public Ouvrage getOuvrageById(int id) {
		Ouvrage o = this.ouvrageRepo.getOuvrageById(id);
		System.out.println(o.getAuteurs().get(0).getNom());
		return o;
	}

	@Override
	public Ouvrage getOuvrageByTitre(String titre) {
		return this.ouvrageRepo.getOuvrageByTitre(titre);
	}

	@Override
	public Ouvrage getOuvrageByISBN(String isbn) {
		return this.ouvrageRepo.getOuvrageByISBN(isbn);
	}

	@Override
	public Ouvrage getOuvrageByDateParution(String date) {
		return this.getOuvrageByDateParution(date);
	}

	@Override
	public List<Ouvrage> listOuvragesByMotCle(String motCle) {
		return this.listOuvragesByMotCle(motCle);
	}

	@Override
	public List<Ouvrage> listOuvragesByAuteur(Auteur a) {
		return this.listOuvragesByAuteur(a);
	}

	@Override
	public List<Ouvrage> listOuvragesByCategorie(Categorie c) {
		return this.listOuvragesByCategorie(c);
	}

	@Override
	public List<Ouvrage> listOuvragesByEditeur(Editeur e) {
		return this.listOuvragesByEditeur(e);
	}

	@Override
	public List<Ouvrage> listOuvrages() {
		return this.listOuvrages();
	}

	@Override
	public void deleteOuvrage(Ouvrage o) {
		this.ouvrageRepo.deleteOuvrage(o);
	}

}
