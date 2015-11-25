package tn.insat.jebouquine.business.implementation;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import tn.insat.jebouquine.business.facade.*;
import tn.insat.jebouquine.data.access.facade.*;
import tn.insat.jebouquine.data.entity.*;

@Service("gestionCommande")
@Transactional
public class GestionCommande implements IGestionCommande {

	@Autowired
	@Qualifier("commandeRepository")
	private ICommandeRepository commandeRepo;
	
	@Override
	public Commande addCommande(Panier p, String modePaiement, String adresseLivraison, double fraisLivraison) {
		Commande cmd = new Commande(new Date().toString(),modePaiement,fraisLivraison,adresseLivraison,"en cours",p.getClient(),p.getOuvrages(),null);
		this.commandeRepo.addCommande(cmd);
		for(LigneCommande lc : cmd.getLignesCommande()){
			lc.setCommande(cmd);
		this.commandeRepo.addLigneCommande(lc);
		}
		return cmd;
	}

	@Override
	public void updateCommande(Commande cmd) {
		this.commandeRepo.updateCommande(cmd);
	}

	@Override
	public Commande getCommandeById(int id) {
		return this.commandeRepo.getCommandeById(id);
	}

	@Override
	public List<Commande> listCommandesByDate(String date) {
		return this.commandeRepo.listCommandesByDate(date);
	}

	@Override
	public List<Commande> listCommandesByEtat(String etat) {
		return this.listCommandesByEtat(etat);
	}

	@Override
	public List<Commande> listCommandesByClient(Client c) {
		return this.listCommandesByClient(c);
	}

	@Override
	public List<Commande> listCommandes() {
		return this.listCommandes();
	}

	@Override
	public void deleteCommande(Commande cmd) {
		this.commandeRepo.deleteCommande(cmd);
	}

	@Override
	public void addLigneCommande(LigneCommande lcmd) {
		this.commandeRepo.addLigneCommande(lcmd);
	}

	@Override
	public void updateLigneCommande(LigneCommande lcmd) {
		this.commandeRepo.updateLigneCommande(lcmd);
	}

	@Override
	public LigneCommande getLigneCommandeById(int id) {
		return this.getLigneCommandeById(id);
	}

	@Override
	public void deleteLigneCommande(LigneCommande lcmd) {
		this.deleteLigneCommande(lcmd);
	}

}
