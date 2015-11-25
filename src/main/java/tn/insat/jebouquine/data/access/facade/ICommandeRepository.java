package tn.insat.jebouquine.data.access.facade;

import java.util.List;

import tn.insat.jebouquine.data.entity.*;

public interface ICommandeRepository {

	public void addCommande(Commande cmd);
	public void updateCommande(Commande cmd);
	public Commande getCommandeById(int id);
	public List<Commande> listCommandesByDate(String date);
	public List<Commande> listCommandesByEtat(String etat);
	public List<Commande> listCommandesByClient(Client c);
	public List<Commande> listCommandes();
	public void deleteCommande(Commande cmd);

	public void addLigneCommande(LigneCommande lcmd);
	public void updateLigneCommande(LigneCommande lcmd);
	public LigneCommande getLigneCommandeById(int id);
	public void deleteLigneCommande(LigneCommande lcmd);

}
