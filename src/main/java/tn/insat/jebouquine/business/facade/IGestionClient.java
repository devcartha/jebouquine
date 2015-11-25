package tn.insat.jebouquine.business.facade;

import java.util.*;

import tn.insat.jebouquine.data.entity.*;

public interface IGestionClient {
	
	public void inscribe(Client c);
	public Client authenticate(String login, String password);
	public void updateClient(Client c);
	public Client getClientById(int id);
	public List<Client> listClientsByNomPrenom(String nom, String prenom);
	public Client getClientsByCIN(String cin);
	public Client getClientsByNumPasseport(String numPasseport);
	public List<Client> listClients();
	public void deleteClient(Client c);
	
}
