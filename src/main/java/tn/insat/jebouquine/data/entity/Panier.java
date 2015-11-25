package tn.insat.jebouquine.data.entity;

import java.util.*;

public class Panier {
	private Client client;
	private List<LigneCommande> ouvrages;

	public Panier() {
		super();
		this.ouvrages = new ArrayList<LigneCommande>();
	}
	
	public Panier(Client client, List<LigneCommande> ouvrages) {
		super();
		this.client = client;
		this.ouvrages = ouvrages;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getOuvrages() {
		return ouvrages;
	}

	public void setOuvrages(List<LigneCommande> ouvrages) {
		this.ouvrages = ouvrages;
	}
}
