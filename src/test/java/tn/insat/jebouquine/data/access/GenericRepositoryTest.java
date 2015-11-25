package tn.insat.jebouquine.data.access;

import static org.junit.Assert.*;
import org.junit.*;

import tn.insat.jebouquine.data.access.facade.IGenericRepository;
import tn.insat.jebouquine.data.access.implementation.GenericRepository;
import tn.insat.jebouquine.data.entity.Client;


public class GenericRepositoryTest {
	
	private IGenericRepository<Client> repoClient;
	private Client client;
	@Before
	public void setUp(){
		repoClient = new GenericRepository<Client>(Client.class);
		client = new Client("login","passwd","Chaouechi", "Souhail", "09616807", "00000000","chaouechi.souhail@gmail.com", "Boumhel");
	}
	
	@Test 
	public void testCRUD(){
		testAdd();
		testUpdate();
		testRetrieve();
		testDelete();
	}
	
	public void testAdd() {
		repoClient.add(client);
		Client client2 = repoClient.getById(client.getId());
		assertEquals(client.getNom(), client2.getNom());
	}

	public void testUpdate() {
		Client client2 = repoClient.getById(client.getId());
		client2.setAdresse("Tunis");
		repoClient.update(client2);
		client = repoClient.getById(client.getId());
		assertEquals(client.getAdresse(),"Tunis");
	}
	
	public void testRetrieve() {
		client = repoClient.getById(client.getId());
		System.out.println(client);
	}
	
	public void testDelete() {
		repoClient.delete(client);
		try{
		client = repoClient.getById(client.getId());
		}catch(Exception ex){
			assertTrue(true);
		}
	}

	@After
	public void tearDown(){
		repoClient = null ;
	}
}
