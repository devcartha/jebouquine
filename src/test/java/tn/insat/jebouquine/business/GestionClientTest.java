package tn.insat.jebouquine.business;


import org.junit.*;

import tn.insat.jebouquine.data.access.implementation.ClientRepository;
import tn.insat.jebouquine.data.entity.*;

public class GestionClientTest {

	
	private ClientRepository gestionClient;

	@Before
	public void setUp(){
		gestionClient = new ClientRepository();
		//gestionClient.setRepoClient(new GenericRepository<Client>(Client.class));
	}
	
	@Test
	public void addClientTest() {
		this.gestionClient.addClient(new Client("login", "passwd", "Chaouechi", "Souhail", "09616807", "00000000",
				"chaouechi.souhail@gmail.com", "Boumhel"));
	}

}
