package com.commerce.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.SpringTestContext;
import com.commerce.model.item.Item;

public class ItemServiceTest extends SpringTestContext{

	@Autowired
	ItemService itemService;
	
	@Test
	public void shouldGetValidItem () {
		createNewItem("12er344", "MENS SOCKS", "RED", "swe", 20);
		Item item = itemService.getItem("12er344");
		assertNotNull(item);
		assertEquals("12er344", item.getStyleColorNumber());
		assertEquals("MENS SOCKS", item.getDescription());
	}
}
