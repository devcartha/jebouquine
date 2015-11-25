package tn.insat.jebouquine.data.access.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import tn.insat.jebouquine.data.access.facade.ICommandeRepository;
import tn.insat.jebouquine.data.access.facade.IGenericRepository;
import tn.insat.jebouquine.data.entity.*;

@Repository("commandeRepository")
public class CommandeRepository implements ICommandeRepository {

	@Autowired
	@Qualifier("repoCommande")
	private IGenericRepository<Commande> repoCommande;
	@Autowired
	@Qualifier("repoLigneCommande")
	private IGenericRepository<LigneCommande> repoLigneCommande;

	@Override
	public void addCommande(Commande cmd) {
		this.repoCommande.add(cmd);
	}

	@Override
	public void updateCommande(Commande cmd) {
		this.repoCommande.update(cmd);
	}

	@Override
	public Commande getCommandeById(int id) {
		return this.repoCommande.getById(id);
	}

	@Override
	public List<Commande> listCommandesByDate(String date) {
		Criteria criteria = this.repoCommande.getCriteria();
		criteria.add(Restrictions.eq("date", date));
		return this.repoCommande.listByCriteria(criteria);
	}

	@Override
	public List<Commande> listCommandesByEtat(String etat) {
		Criteria criteria = this.repoCommande.getCriteria();
		criteria.add(Restrictions.eq("etatCommande", etat));
		return this.repoCommande.listByCriteria(criteria);
	}

	@Override
	public List<Commande> listCommandesByClient(Client c) {
		Criteria criteria = this.repoCommande.getCriteria();
		criteria.add(Restrictions.eq("client.id", c.getId()));
		return this.repoCommande.listByCriteria(criteria);
	}

	@Override
	public List<Commande> listCommandes() {
		return this.repoCommande.getAll();
	}

	@Override
	public void deleteCommande(Commande cmd) {
		this.repoCommande.delete(cmd);
	}

	@Override
	public void addLigneCommande(LigneCommande lcmd) {
		this.repoLigneCommande.add(lcmd);
	}

	@Override
	public void updateLigneCommande(LigneCommande lcmd) {
		this.repoLigneCommande.update(lcmd);
	}

	@Override
	public LigneCommande getLigneCommandeById(int id) {
		return this.repoLigneCommande.getById(id);
	}

	@Override
	public void deleteLigneCommande(LigneCommande lcmd) {
		this.repoLigneCommande.delete(lcmd);
	}

}
