package tn.insat.jebouquine.business.facade;

import tn.insat.jebouquine.data.entity.*;

public interface IGestionPanier {
	public Panier getPanier(Client c);
	public void addOuvrage(Panier p,Ouvrage o, int quantite, double prix);
	public void updateOuvrageQuantite(Panier p, Ouvrage o, int quantite);
	public void updateOuvragePrix(Panier p, Ouvrage o, int prix);
	public void deleteOuvrage(Panier p, Ouvrage o);
}
