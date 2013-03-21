package com.commerce.dao.item;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.SpringTestContext;
import com.commerce.model.item.Item;
import static org.junit.Assert.assertNotNull;


public class ItemRepositoryTest extends SpringTestContext{

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	public void shouldFetchNothingFromItemsTable() {
		System.out.println(itemRepository.fetchItem(null));
	}
	@Test
	public void shouldFetchValidItemwithStyleColrNumber() {
		createNewItem("12er344", "MENS SOCKS", "RED", "swe", 20);
		Item item  = itemRepository.fetchItem("12er344");
		assertNotNull(item);
	}
}
