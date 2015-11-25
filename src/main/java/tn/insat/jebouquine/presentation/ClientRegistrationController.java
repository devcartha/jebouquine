package tn.insat.jebouquine.presentation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionClient;
import tn.insat.jebouquine.data.entity.Client;

@Controller
public class ClientRegistrationController {

	@Autowired
	private IGestionClient gestionClient;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("registrationForm");
		mv.addObject("user", new Client());
		return mv;		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Client client) {
		this.gestionClient.inscribe(client);
		ModelAndView mv = new ModelAndView("registrationSuccess");		
		mv.addObject("user",client);
		return mv;
	}
	
	
	
	
}
