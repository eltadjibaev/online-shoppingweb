package net.elmu.shoppingbackendside.dao;

import java.util.List;

import net.elmu.shoppingbackendside.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
