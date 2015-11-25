package tn.insat.jebouquine.business.implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import tn.insat.jebouquine.business.facade.*;
import tn.insat.jebouquine.data.access.facade.*;
import tn.insat.jebouquine.data.entity.*;

@Service("gestionFacture")
@Transactional
public class GestionFacture implements IGestionFacture{

	@Autowired
	@Qualifier("factureRepository")
	private IFactureRepository factureRepo;
	
	@Override
	public Facture addFacture(Commande cmd) {
		double total = 0;
		for (LigneCommande lc : cmd.getLignesCommande())
			total+=lc.getPrix()*lc.getQuantite();
		Facture facture = new Facture(new Date().toString(),"Non payé",total,cmd);
		this.factureRepo.addFacture(facture);
		return facture;
	}

	@Override
	public void updateFacture(Facture f) {
		this.factureRepo.updateFacture(f);
	}

	@Override
	public Facture getFactureById(int id) {
		return this.factureRepo.getFactureById(id);
	}

	@Override
	public List<Facture> listFacturesByDate(String dateFacturation) {
		return this.factureRepo.listFacturesByDate(dateFacturation);
	}

	@Override
	public List<Facture> listFacturesByEtat(String etatFacutre) {
		return this.factureRepo.listFacturesByEtat(etatFacutre);
	}

	@Override
	public List<Facture> listFacturesByClient(Client c) {
		return this.factureRepo.listFacturesByClient(c);
	}

	@Override
	public List<Facture> listFactures() {
		return this.factureRepo.listFactures();
	}

	@Override
	public void deleteFacture(Facture f) {
		this.factureRepo.deleteFacture(f);
	}

}
