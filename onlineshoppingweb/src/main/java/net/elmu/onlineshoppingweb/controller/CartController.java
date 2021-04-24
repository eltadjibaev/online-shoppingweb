package net.elmu.onlineshoppingweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.elmu.onlineshoppingweb.service.CartService;
import net.elmu.shoppingbackendside.dto.CartLine;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
		ModelAndView mv = new ModelAndView("page");
		if (result != null) {
			switch (result) {
			case "update":
				mv.addObject("message", "CartLine has been updated successfully!");
				break;
			case "added":
				mv.addObject("message", "CartLine has been added successfully!");
				break;
			case "deleted":
				mv.addObject("message", "CartLine has been deleted successfully!");
				break;
			case "maximum":
				mv.addObject("message", "CartLine has reached to maximum count!");
				break;
			case "unavailable":
				mv.addObject("message", "Product quantity is not available!");
				break;
			case "error":
				mv.addObject("message", "Something went wrong!");
				break;
			}
		
		}

		List<CartLine> cartlines = cartService.getCartLines();

		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartlines);

		return mv;
	}

	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {
		String response = cartService.manageCartLine(cartLineId, count);
		return "redirect:/cart/show?" + response;
	}
	
	
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {
		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?" + response;
	}
	
	
	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {
		String response = cartService.addCartLine(productId);
		return "redirect:/cart/show?" + response;
	}
	
}















