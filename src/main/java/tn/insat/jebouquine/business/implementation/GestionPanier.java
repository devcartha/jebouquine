package tn.insat.jebouquine.business.implementation;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import tn.insat.jebouquine.business.facade.*;
import tn.insat.jebouquine.data.entity.*;

@Service("gestionPanier")
@Transactional
public class GestionPanier implements IGestionPanier {
	
	@Override
	public Panier getPanier(Client c){
		Panier panier = new Panier(c,new ArrayList<LigneCommande>());
		return panier;
	}
	
	@Override
	public void addOuvrage(Panier p, Ouvrage o, int quantite, double prix) {
		p.getOuvrages().add(new LigneCommande(prix, quantite, o));
	}

	@Override
	public void updateOuvrageQuantite(Panier p, Ouvrage o, int quantite) {
		for (LigneCommande lc : p.getOuvrages()){
			if (lc.getOuvrage().getISBN().equals(o.getISBN())){
				lc.setQuantite(quantite);
				break;
			}
		}
	}

	@Override
	public void updateOuvragePrix(Panier p, Ouvrage o, int prix) {
		for (LigneCommande lc : p.getOuvrages()){
			if (lc.getOuvrage().getISBN().equals(o.getISBN())){
				lc.setPrix(prix);
				break;
			}
		}
	}

	@Override
	public void deleteOuvrage(Panier p, Ouvrage o) {
		for (LigneCommande lc : p.getOuvrages()){
			if (lc.getOuvrage().getISBN().equals(o.getISBN())){
				p.getOuvrages().remove(lc);
				break;
			}
		}
	}


}
