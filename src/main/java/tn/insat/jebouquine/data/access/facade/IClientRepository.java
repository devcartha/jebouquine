package tn.insat.jebouquine.data.access.facade;

import java.util.List;

import tn.insat.jebouquine.data.entity.Client;

public interface IClientRepository {

	public void addClient(Client c);
	public void updateClient(Client c);
	public Client getClientById(int id);
	public Client getClientByLoginPassword(String login, String password);
	public List<Client> listClientsByNomPrenom(String nom, String prenom);
	public Client getClientsByCIN(String cin);
	public Client getClientsByNumPasseport(String numPasseport);
	public List<Client> listClients();
	public void deleteClient(Client c);
	
}
