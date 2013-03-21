package com.commerce.dao.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.SpringTestContext;
import com.commerce.model.item.Item;


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
	
	@Test
	public void shouldFetchAllItems() {
		createNewItem("12er34456", "MENS SOCKS", "RED", "swe", 20);
		createNewItem("12er36756", "MENS SOCKS", "RED", "swe", 20);
		List<Item> items = itemRepository.fetchAllItems();
		assertNotNull(items);
		assertEquals(2, items.size());
		
	}
	
	@Test
	public void shouldInsertAllItems () {
		Item item1 = buildItem("125d34456", "MENS SOCKS", "RED", "swe", 20);
		Item item2 = buildItem("12th34456", "MENS SOCKS", "RED", "swe", 20);
		List<Item> items = new ArrayList<Item>();
		items.add(item2);
		items.add(item1);
		itemRepository.storeItems(items);
		items = itemRepository.fetchAllItems();
		assertNotNull(items);
		assertEquals(2, items.size());
		assertEquals(true, ( items.get(0).getStyleColorNumber().equals("125d34456") || items.get(1).getStyleColorNumber().equals("125d34456") ));
		assertEquals(true, ( items.get(0).getStyleColorNumber().equals("12th34456") || items.get(1).getStyleColorNumber().equals("12th34456") ));
		
	}
	@Test
	public void shouldDeleteAllitems () {
		createNewItem("3434456", "MENS SOCKS", "RED", "swe", 20);
		createNewItem("2w336756", "MENS SOCKS", "RED", "swe", 20);
		Item item1 = buildItem("3434456", "MENS SOCKS", "RED", "swe", 20);
		Item item2 = buildItem("2w336756", "MENS SOCKS", "RED", "swe", 20);
		List<Item> items = new ArrayList<Item>();
		items.add(item2);
		items.add(item1);
		itemRepository.deleteItems(items);
		items = itemRepository.fetchAllItems();
		assertEquals(0, items.size());
	}
	
}
