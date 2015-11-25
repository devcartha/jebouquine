package tn.insat.jebouquine.data.access.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tn.insat.jebouquine.data.access.facade.IClientRepository;
import tn.insat.jebouquine.data.access.facade.IGenericRepository;
import tn.insat.jebouquine.data.entity.Client;

@Repository("clientRepository")
public class ClientRepository implements IClientRepository{

	@Autowired
	@Qualifier("repoClient")
	IGenericRepository<Client> repoClient;
	
	@Override
	public void addClient(Client c) {
		this.repoClient.add(c);
	}

	@Override
	public void updateClient(Client c) {
		this.repoClient.update(c);
	}

	@Override
	public Client getClientById(int id) {
		return this.repoClient.getById(id);
	}

	@Override
	public Client getClientByLoginPassword(String login, String password){
		Criteria criteria = this.repoClient.getCriteria();
		criteria.add(Restrictions.eq("login", login)).add(Restrictions.eq("password", password));
		return this.repoClient.getByCriteria(criteria);
	}
	
	@Override
	public List<Client> listClientsByNomPrenom(String nom, String prenom) {
		Criteria criteria = this.repoClient.getCriteria();
		criteria.add(Restrictions.eq("nom", nom)).add(Restrictions.eq("prenom", prenom));
		return this.repoClient.listByCriteria(criteria);
	}

	@Override
	public Client getClientsByCIN(String cin) {
		Criteria criteria = this.repoClient.getCriteria();
		criteria.add(Restrictions.eq("cin", cin));
		return this.repoClient.getByCriteria(criteria);
	}

	@Override
	public Client getClientsByNumPasseport(String numPasseport) {
		Criteria criteria = this.repoClient.getCriteria();
		criteria.add(Restrictions.eq("numPasseport", numPasseport));
		return this.repoClient.getByCriteria(criteria);
	}

	@Override
	public List<Client> listClients() {
		return this.repoClient.getAll();
	}

	@Override
	public void deleteClient(Client c) {
		this.repoClient.delete(c);
	}

	
	
}
