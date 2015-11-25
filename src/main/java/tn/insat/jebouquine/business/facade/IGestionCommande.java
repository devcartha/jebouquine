package tn.insat.jebouquine.business.facade;
import java.util.List;

import tn.insat.jebouquine.data.entity.*;

public interface IGestionCommande {
	
	public Commande addCommande(Panier p, String modePaiement, String adresseLivraison, double fraisLivraison);
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
