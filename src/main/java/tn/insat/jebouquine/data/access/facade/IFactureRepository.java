package tn.insat.jebouquine.data.access.facade;

import java.util.List;

import tn.insat.jebouquine.data.entity.*;

public interface IFactureRepository {
	public void addFacture(Facture f);
	public void updateFacture(Facture f);
	public Facture getFactureById(int id);
	public List<Facture> listFacturesByDate(String dateFacturation);
	public List<Facture> listFacturesByEtat(String etatFacutre);
	public List<Facture> listFacturesByClient(Client c);
	public List<Facture> listFactures();
	public void deleteFacture(Facture f);
}
