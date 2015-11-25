package tn.insat.jebouquine.business.facade;

import java.util.*;
import tn.insat.jebouquine.data.entity.*;

public interface IGestionFacture {
	public Facture addFacture(Commande cmd);
	public void updateFacture(Facture f);
	public Facture getFactureById(int id);
	public List<Facture> listFacturesByDate(String dateFacturation);
	public List<Facture> listFacturesByEtat(String etatFacutre);
	public List<Facture> listFacturesByClient(Client c);
	public List<Facture> listFactures();
	public void deleteFacture(Facture f);
}
