package com.commerce.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.SpringTestContext;
import com.commerce.model.item.Item;

public class ItemControllerTest extends SpringTestContext{

	@Autowired
	ItemController itemController;
	
	@Test
	public void shouldGetItem() {
		createNewItem("12er34456", "MENS SOCKS", "RED", "swe", 20);
		Item item = itemController.getItem("12er34456");
		assertNotNull(item);
	}
	
	@Test
	public void shouldCreateNewItem() {
		Item item1 = buildItem("125d344th6", "MENS SOCKS", "RED", "swe", 20);
		itemController.createItem(item1);
		Item expectedItem = itemController.getItem(item1.getStyleColorNumber());
		assertNotNull(expectedItem);
	}
}
