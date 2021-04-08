package net.elmu.shoppingbackendside.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.elmu.shoppingbackendside.dao.CategoryDAO;
import net.elmu.shoppingbackendside.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.elmu.shoppingbackendside");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Something wrong in add method!", true, categoryDAO.add(category));
	}
	
	@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(2);
		
		assertEquals("Some thing wrong in a single category getting method!!", "Laptop", category.getName());
	}
	
	
	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(1);
		category.setName("TV");
	
		assertEquals("Something wrong in update method!", true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(1);
	
		assertEquals("Something wrong in delete method!", true, categoryDAO.delete(category));
	}
	
	@Test
	public void testListCategory() {
	
		assertEquals("Something wrong in List method!", 2, categoryDAO.list().size());
	}*/

	@Test
	public void testCRUDCategory() {

		// adding a new category
		category = new Category();

		category.setName("Handwatch");
		category.setDescription("This is some description for Handwatch");
		category.setImageURL("CAT_4.png");

		assertEquals("Something wrong in add method!", true, categoryDAO.add(category));
		
		
		// fetching and updating the category
		category = categoryDAO.get(4);
		category.setName("Handwatches");
	
		assertEquals("Something wrong in update method!", true, categoryDAO.update(category));
		
		// delete the category
		assertEquals("Something wrong in delete method!", true, categoryDAO.delete(category));
		
		// fetching the list
		assertEquals("Something wrong in List method!", 2, categoryDAO.list().size());

	}

}














