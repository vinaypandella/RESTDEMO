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

import com.commerce.RecordNotFoundException;
import com.commerce.model.item.Item;
import com.commerce.model.item.Items;
import com.commerce.services.ItemService;

@Controller
@RequestMapping("/")
public class ItemController {

	@Autowired
	ItemService itemService;
	
    private static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
    
	@RequestMapping(value = "items", method = RequestMethod.GET)
    @ResponseBody
	public List<Item> getAllItems () {
		return itemService.getItems();
	}
	
	@RequestMapping(value = "items", method = RequestMethod.DELETE)
    @ResponseBody
	public void deleteItems (@RequestBody Items items) {
		itemService.deleteItems(items);
	}
	
	@RequestMapping(value = "items", method = POST)
    @ResponseBody
	public List<Item> createItems (@RequestBody Items items) {
		return itemService.updateItems(items);
	}
	

	@RequestMapping(value = "items", method = PUT)
    @ResponseBody
	public List<Item> replaceItems (@RequestBody Items items) {
		return itemService.replaceItems(items);
	}
	
	@RequestMapping(value = "items/item/{styleColorNumber}", method = RequestMethod.DELETE)
    @ResponseBody
	public int deleteItem (@PathVariable String styleColorNumber) {
		return itemService.deleteItem(styleColorNumber);
	}
	
	@RequestMapping(value = "items/item/{styleColorNumber}", method = RequestMethod.GET)
    @ResponseBody
	public Item getItem (@PathVariable String styleColorNumber) throws RecordNotFoundException {
		LOGGER.info("in controller...");
		return itemService.getItem(styleColorNumber);
	}
	
	@RequestMapping(value = "items/createitem", method = POST)
    @ResponseBody
	public Item createItem (@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	
	@RequestMapping(value = "items/item", method = PUT)
    @ResponseBody
	public Item updateItem (@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	
	
	

	
	
	
}
