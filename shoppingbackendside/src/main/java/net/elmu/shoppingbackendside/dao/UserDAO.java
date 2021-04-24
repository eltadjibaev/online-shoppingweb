package net.elmu.shoppingbackendside.dao;

import java.util.List;

import net.elmu.shoppingbackendside.dto.Address;
import net.elmu.shoppingbackendside.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	// add an address
	boolean addAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	
}
