package tn.insat.jebouquine.data.access.implementation;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import tn.insat.jebouquine.data.access.facade.IFactureRepository;
import tn.insat.jebouquine.data.access.facade.IGenericRepository;
import tn.insat.jebouquine.data.entity.*;

@Repository("factureRepository")
public class FactureRepository implements IFactureRepository {

	@Autowired
	@Qualifier("repoFacture")
	private IGenericRepository<Facture> repoFacture;

	@Override
	public void addFacture(Facture f) {
		this.repoFacture.add(f);
	}

	@Override
	public void updateFacture(Facture f) {
		this.repoFacture.update(f);
	}

	@Override
	public Facture getFactureById(int id) {
		return this.repoFacture.getById(id);
	}

	@Override
	public List<Facture> listFacturesByDate(String dateFacturation) {
		Criteria criteria = this.repoFacture.getCriteria();
		criteria.add(Restrictions.eq("dateFacturation", dateFacturation));
		return this.repoFacture.listByCriteria(criteria);
	}

	@Override
	public List<Facture> listFacturesByEtat(String etatFacutre) {
		Criteria criteria = this.repoFacture.getCriteria();
		criteria.add(Restrictions.eq("etatFacutre", etatFacutre));
		return this.repoFacture.listByCriteria(criteria);
	}

	@Override
	public List<Facture> listFacturesByClient(Client c) {
		Criteria criteria = this.repoFacture.getCriteria();
		criteria.createAlias("commande.client", "client");
		criteria.add(Restrictions.eq("client.id", c.getId()));
		return this.repoFacture.listByCriteria(criteria);
	}

	@Override
	public List<Facture> listFactures() {
		return this.repoFacture.getAll();
	}

	@Override
	public void deleteFacture(Facture f) {
		this.repoFacture.delete(f);
	}

}
