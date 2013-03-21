package com.commerce.dao.item;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.SpringTestContext;
import com.commerce.model.item.Item;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;


public class ItemRepositoryTest extends SpringTestContext{

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void shouldFetchNothingFromItemsTable() {
		assertNull(itemRepository.fetchItem(null));
	}
	@Test
	public void shouldFetchValidItemwithStyleColrNumber() {
		createNewItem("12er344", "MENS SOCKS", "RED", "swe", 20);
		Item item  = itemRepository.fetchItem("12er344");
		assertNotNull(item);
	}
	
	@Test
	public void shouldUpdateItemPrice() {
		createNewItem("12er344", "MENS SOCKS", "RED", "swe", 20);
		Item item  = itemRepository.fetchItem("12er344");
		assertEquals(20, item.getPrice());
		item.setPrice(30);
		itemRepository.updatePrice(item);
		Item updatedItem  = itemRepository.fetchItem("12er344");
		assertNotNull(updatedItem);
		assertNotNull(item);
		assertEquals(30, updatedItem.getPrice());
	}
	
	@Test
	public void shoudlDeleteItem () {
		createNewItem("12er34456", "MENS SOCKS", "RED", "swe", 20);
		Item item  = itemRepository.fetchItem("12er34456");
		assertNotNull(item);
		itemRepository.deleteItem("12er34456");
		Item deletedItem  = itemRepository.fetchItem("12er34456");
		assertNull(deletedItem);
	}
}
