package whatsappweb;

import static org.junit.Assert.*;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import com.whatsappweb.dao.WhatsappDAOInterface;
import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.utility.DAOFactory;

public class WhatsappDAOHibernateTest {

	WhatsappDAOInterface wd;
	@Before
	public void setUp() throws Exception {
		wd=DAOFactory.createObjectHibernate();
	}

	@After
	public void tearDown() throws Exception {
		wd=null;
	}


	@Test
	public void testCreateProfileDAO() {
		
		  WhatsappUser wu=new WhatsappUser();
		  
		  wu.setName("Sindhuja"); 
		  wu.setPhone("8667886432"); 
		  wu.setAge("20");
		  wu.setEmail("sindhuja123@gmail.com"); 
		  wu.setUsername("sindhu981");
		  wu.setPassword("sindhuja546");
		  
		  int i=wd.createProfileDAO(wu);
		  
		  assert i>0:"Registration failed";
		 
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testLoginProfileDAO() {
		WhatsappUser wu=new WhatsappUser();
		wu.setUsername("sindhuja981");
		wu.setPassword("sindhuja546");
		boolean b=wd.loginProfileDAO(wu);
		assert (b=true):"login failed ";
		
		//fail("Not yet implemented");
	}

	@Test
	public void testViewProfileDAO() {
		
		  WhatsappUser wu=new WhatsappUser(); 
		  wu.setName("Sindhuja"); 
		  wu.setPhone("8667886432"); 
		  wu.setAge("20");
		  wu.setEmail("sindhuja123@gmail.com"); 
		  wu.setUsername("sindhu981");
		  wu.setPassword("sindhuja546");
		  
		  WhatsappUser b=wd.viewProfileDAO(wu);
		  
		  
		  assert (b!=null):"view details failed";
		 
		

		
		//fail("Not yet implemented");
	}

	

	
	
	
	@Test
	public void testDeleteProfile() {
		WhatsappUser wu=new WhatsappUser();
		wu.setUsername("sindhu981");
		  wu.setPassword("sindhuja546");
		  
         int i=wd.deleteProfile(wu);
		  
		  assert i>0:"cannot delete user";
		
		//fail("Not yet implemented");
	}
	
	
	
	
	
	@Test
	public void testEditProfileDAO() {
		
		/*
		 * WhatsappUser wu=new WhatsappUser();
		 * 
		 * wu.setName("Sindhuja"); wu.setPhone("8667886432"); wu.setAge("20");
		 * wu.setEmail("sindhuja123@gmail.com"); wu.setUsername("sindhu");
		 * wu.setPassword("sindhuja546");
		 * 
		 * int i=wd.editProfileDAO(wu);
		 * 
		 * assert i>0:"cannot update details";
		 */
		 
		
		
		//fail("Not yet implemented");
	}

}
