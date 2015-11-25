package tn.insat.jebouquine.data.access.implementation;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import tn.insat.jebouquine.data.access.facade.IGenericRepository;
import tn.insat.jebouquine.data.access.facade.IOuvrageRepository;
import tn.insat.jebouquine.data.entity.*;

@Repository("ouvrageRepository")
public class OuvrageRepository implements IOuvrageRepository {

	@Autowired
	@Qualifier("repoOuvrage")
	private IGenericRepository<Ouvrage> repoOuvrage;
	@Autowired
	@Qualifier("repoAuteur")
	private IGenericRepository<Auteur> repoAuteur;
	@Autowired
	@Qualifier("repoEditeur")
	private IGenericRepository<Editeur> repoEditeur;
	@Autowired
	@Qualifier("repoCategorie")
	private IGenericRepository<Categorie> repoCategorie;

	@Override
	public void addAuteur(Auteur a) {
		this.repoAuteur.add(a);
	}

	@Override
	public void updateAuteur(Auteur a) {
		this.repoAuteur.update(a);
	}

	@Override
	public Auteur getAutuerById(int id) {
		return this.repoAuteur.getById(id);
	}

	@Override
	public List<Auteur> listAuteursByNomPrenom(String nom, String prenom) {
		Criteria criteria = this.repoAuteur.getCriteria();
		criteria.add(Restrictions.eq("nom", nom));
		criteria.add(Restrictions.eq("prenom", prenom));
		return this.repoAuteur.listByCriteria(criteria);
	}

	@Override
	public List<Auteur> listAuteursByNationnalite(String nationalite) {
		Criteria criteria = this.repoAuteur.getCriteria();
		criteria.add(Restrictions.eq("nationalite", nationalite));
		return this.repoAuteur.listByCriteria(criteria);
	}

	@Override
	public List<Auteur> listAuteurs() {
		return this.repoAuteur.getAll();
	}

	@Override
	public void addEditeur(Editeur e) {
		this.repoEditeur.add(e);
	}

	@Override
	public void updateEditeur(Editeur e) {
		this.repoEditeur.update(e);
	}

	@Override
	public Editeur getEditeurById(int id) {
		return this.repoEditeur.getById(id);
	}

	@Override
	public Editeur getEditeurByNom(String nom) {
		Criteria criteria = this.repoEditeur.getCriteria();
		criteria.add(Restrictions.eq("nom", nom));
		return this.repoEditeur.getByCriteria(criteria);
	}

	@Override
	public List<Editeur> listEditeurs() {
		return this.repoEditeur.getAll();
	}

	@Override
	public void addCategorie(Categorie c) {
		this.repoCategorie.add(c);
	}

	@Override
	public void updateCategorie(Categorie c) {
		this.repoCategorie.update(c);
	}

	@Override
	public Categorie getCategorieById(int id) {
		return this.repoCategorie.getById(id);
	}

	@Override
	public List<Categorie> listCategories() {
		return this.repoCategorie.getAll();
	}

	@Override
	public void addOuvrage(Ouvrage o) {
		this.repoOuvrage.add(o);
	}

	@Override
	public void updateOuvrage(Ouvrage o) {
		this.repoOuvrage.update(o);
	}

	@Override
	public Ouvrage getOuvrageById(int id) {
		return this.repoOuvrage.getById(id);
	}

	@Override
	public Ouvrage getOuvrageByTitre(String titre) {
		Criteria criteria = this.repoOuvrage.getCriteria();
		criteria.add(Restrictions.eq("titre", titre));
		return this.repoOuvrage.getByCriteria(criteria);
	}

	@Override
	public Ouvrage getOuvrageByISBN(String isbn) {
		Criteria criteria = this.repoOuvrage.getCriteria();
		criteria.add(Restrictions.eq("ISBN", isbn));
		return this.repoOuvrage.getByCriteria(criteria);
	}

	@Override
	public Ouvrage getOuvrageByDateParution(String date) {
		Criteria criteria = this.repoOuvrage.getCriteria();
		criteria.add(Restrictions.eq("dateParution", date));
		return this.repoOuvrage.getByCriteria(criteria);
	}

	@Override
	public List<Ouvrage> listOuvragesByMotCle(String motCle) {
		Criteria criteria = this.repoOuvrage.getCriteria();
		criteria.createAlias("auteurs", "auteur");
		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.like("titre", "%"+motCle+"%"));
		or.add(Restrictions.like("ISBN", "%"+motCle+"%"));
		or.add(Restrictions.like("dateParution", "%"+motCle+"%"));
		or.add(Restrictions.like("auteur.nom", "%"+motCle+"%"));
		or.add(Restrictions.like("auteur.prenom", "%"+motCle+"%"));
		//or.add(Restrictions.like("categorie.titre", "%"+motCle+"%"));
		//or.add(Restrictions.like("editeur.nom", "%"+motCle+"%"));
		criteria.add(or);
		criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		return this.repoOuvrage.listByCriteria(criteria);
	}

	@Override
	public List<Ouvrage> listOuvragesByAuteur(Auteur a) {
		Criteria criteria = this.repoOuvrage.getCriteria();
		criteria.createAlias("auteurs", "auteur");
		criteria.add(Restrictions.eq("auteur.id", a.getId()));
		return this.repoOuvrage.listByCriteria(criteria);
	}

	@Override
	public List<Ouvrage> listOuvragesByCategorie(Categorie c) {
		Criteria criteria = this.repoOuvrage.getCriteria();
		criteria.add(Restrictions.eq("categorie.id", c.getId()));
		return this.repoOuvrage.listByCriteria(criteria);
	}

	@Override
	public List<Ouvrage> listOuvragesByEditeur(Editeur e) {
		Criteria criteria = this.repoOuvrage.getCriteria();
		criteria.add(Restrictions.eq("editeur.id", e.getId()));
		return this.repoOuvrage.listByCriteria(criteria);
	}

	@Override
	public List<Ouvrage> listOuvrages() {
		return this.repoOuvrage.getAll();
	}

	@Override
	public void deleteAuteur(Auteur a) {
		this.repoAuteur.delete(a);
	}

	@Override
	public void deleteEditeur(Editeur e) {
		this.repoEditeur.delete(e);
	}

	@Override
	public void deleteCategorie(Categorie c) {
		this.repoCategorie.delete(c);
	}

	@Override
	public void deleteOuvrage(Ouvrage o) {
		this.repoOuvrage.delete(o);
	}

}
