package com.commerce.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commerce.model.item.Item;
import com.commerce.services.ItemService;

@Controller
@RequestMapping("/")
public class ItemController {

	@Autowired
	ItemService itemService;
	
    private static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	@RequestMapping(value = "items/item/{styleColorNumber}", method = RequestMethod.GET)
    @ResponseBody
	public Item getItem (@PathVariable String styleColorNumber) {
		LOGGER.info("in controller...");
		return itemService.getItem(styleColorNumber);
	}
	
	@RequestMapping(value = "items", method = RequestMethod.GET)
    @ResponseBody
	public List<Item> getAllItems () {
		return itemService.getItems();
	}
	
	@RequestMapping(value = "items/createitem", method = POST)
    @ResponseBody
	public Item createItem (@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	@RequestMapping(value = "items/createitems", method = POST)
    @ResponseBody
	public List<Item> createItems (@RequestBody List<Item> items) {
		return itemService.updateItems(items);
	}
	
	
}
