package tn.insat.jebouquine.business.implementation;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import tn.insat.jebouquine.business.facade.*;
import tn.insat.jebouquine.data.access.facade.*;
import tn.insat.jebouquine.data.entity.*;

@Service("gestionClient")
@Transactional
public class GestionClient implements IGestionClient {

	@Autowired
	@Qualifier("clientRepository")
	private IClientRepository clientRepo;

	@Override
	public void inscribe(Client c) {
		this.clientRepo.addClient(c);
	}

	@Override
	public Client authenticate(String login, String password) {
		try {
			return this.clientRepo.getClientByLoginPassword(login, password);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void updateClient(Client c) {
		this.clientRepo.updateClient(c);
	}

	@Override
	public Client getClientById(int id) {
		return this.clientRepo.getClientById(id);
	}

	@Override
	public List<Client> listClientsByNomPrenom(String nom, String prenom) {
		return this.clientRepo.listClientsByNomPrenom(nom, prenom);
	}

	@Override
	public Client getClientsByCIN(String cin) {
		return this.getClientsByCIN(cin);
	}

	@Override
	public Client getClientsByNumPasseport(String numPasseport) {
		return this.getClientsByNumPasseport(numPasseport);
	}

	@Override
	public List<Client> listClients() {
		return this.clientRepo.listClients();
	}

	@Override
	public void deleteClient(Client c) {
		this.clientRepo.deleteClient(c);
	}

}
