package tn.insat.jebouquine.configuration;

import java.util.ArrayList;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tn.insat.jebouquine.data.access.facade.IOuvrageRepository;
import tn.insat.jebouquine.data.entity.*;

public class AppConfigTest {
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ApplicationContextConfig.class);
		ctx.refresh();
		IOuvrageRepository gestionBibliotheque = ctx.getBean(IOuvrageRepository.class);
		Editeur editeur = new Editeur("Eyrolles");
		gestionBibliotheque.addEditeur(editeur);
		Auteur auteur =  new Auteur("chaouechi","hassen","tunisienne","hassen@gmail.com");
		ArrayList<Auteur> auteurs = new ArrayList<Auteur> ();
		auteurs.add(auteur);
		gestionBibliotheque.addAuteur(auteur);
		Ouvrage ouvrage = new Ouvrage("titre","007","12/12/2015","55",12,10,null,auteurs,editeur);
		gestionBibliotheque.addOuvrage(ouvrage);
		System.out.println(gestionBibliotheque.listOuvragesByMotCle("hassen").size());
		//System.out.println(gestionBibliotheque.listOuvragesByAuteur(auteur).get(0));
		ctx.close();
	}

}
