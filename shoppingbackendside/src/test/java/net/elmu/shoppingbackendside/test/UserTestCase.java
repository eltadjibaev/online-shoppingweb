package net.elmu.shoppingbackendside.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.elmu.shoppingbackendside.dao.UserDAO;
import net.elmu.shoppingbackendside.dto.Address;
//import net.elmu.shoppingbackendside.dto.Cart;
import net.elmu.shoppingbackendside.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	//private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.elmu.shoppingbackendside");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Elmu");
		user.setLastName("Tadjibaev");
		user.setEmail("eltadjiabev@gmail.com");
		user.setContactNumber("01021774454");
		user.setRole("USER");
		user.setPassword("123456");
		
		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, London street");
		address.setAddressLineTwo("Near London Store");
		address.setCity("London");
		address.setState("BMT");
		address.setCountry("Britain");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		// link the user with the address using user id
		//address.setUserId(user.getId());
		
		// add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
				
		if(user.getRole().equals("USER")) {
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			// add the cart
			//assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			// add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("10/B Jadoo Society, Tokyo street");
			address.setAddressLineTwo("Near Tokyo Store");
			address.setCity("Tokyo");
			address.setState("ASIA");
			address.setCountry("Japan");
			address.setPostalCode("50005");
			address.setShipping(true);
			
			// link it with the user
			//address.setUserId(user.getId());
			
			// add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		}

	}*/
	
	/*@Test
	public void testAddAddress() {
		//we need to add an user
		user = new User();
		user.setFirstName("Dima");
		user.setLastName("Tadjibaev");
		user.setEmail("dima@gmail.com");
		user.setContactNumber("01021774454");
		user.setRole("USER");
		user.setPassword("12345");
		
		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		// we are going to add the address
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Uchkurgan street");
		address.setAddressLineTwo("Near Namangan Store");
		address.setCity("Tashkent");
		address.setState("ASIA");
		address.setCountry("Uzbekistan");
		address.setPostalCode("4001");
		address.setBilling(true);
		
		// attached the user to the address
		address.setUser(user);
		
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		
		// add a shipping address for this user
					address = new Address();
					address.setAddressLineOne("1/B Jadoo Society, Tokyo street");
					address.setAddressLineTwo("Near Tokyo Store");
					address.setCity("Tokyo");
					address.setState("ASIA");
					address.setCountry("Japan");
					address.setPostalCode("5005");
					address.setShipping(true);
					
					// attached the user to the address
					address.setUser(user);
					
					assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	}*/
	
	
	/*@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("dima@gmail.com");
		
		// we are going to add the shipping address
		address = new Address();
		address.setAddressLineOne("1/B Jadoo Society, Busan street");
		address.setAddressLineTwo("Near Busan Store");
		address.setCity("Seoul");
		address.setState("ASIA");
		address.setCountry("South Korea");
		address.setPostalCode("500544");
		address.setShipping(true);
		
		// attached the user to the address
		address.setUser(user);
		
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	}*/
	
	
	@Test
	public void testGetAddress() {
		user = userDAO.getByEmail("dima@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size doesn't match", 2, userDAO.listShippingAddresses(user.getId()).size());
		
		assertEquals("Failed to fetch the list of address and size doesn't match", "Tashkent", userDAO.getBillingAddress(user.getId()).getCity());
	}
	
}
















