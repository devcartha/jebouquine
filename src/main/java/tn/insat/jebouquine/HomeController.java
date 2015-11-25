package tn.insat.jebouquine;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.insat.jebouquine.business.facade.*;
import tn.insat.jebouquine.data.entity.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	@Qualifier("gestionClient")
	private IGestionClient gestionClient;
	
	@Autowired
	@Qualifier("gestionOuvrage")
	private IGestionOuvrage gestionOuvrage;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		Ouvrage o = this.gestionOuvrage.getOuvrageById(1);
		//o.getAuteurs();
		
		Client c = this.gestionClient.authenticate("souhail", "souhail");

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("client", o.getTitre() + " " + c.getPrenom());

		return "home";
	}

}
