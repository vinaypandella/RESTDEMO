package com.commerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.commerce.RecordNotFoundException;
import com.commerce.dao.item.ItemRepository;
import com.commerce.model.item.Item;

@Component
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item getItem(String styleColorNumber) throws RecordNotFoundException {
		Item item = itemRepository.fetchItem(styleColorNumber);
		if(null == item) {
			throw new RecordNotFoundException();
		}
		return item;
	}
	
	public Item createItem(Item item) {
		itemRepository.updatePrice(item);
		return itemRepository.fetchItem(item.getStyleColorNumber());
	}
	
	public int deleteItem (String styleColorNumber) {
		return itemRepository.deleteItem(styleColorNumber);
	}
	
	public List<Item> getItems () {
		return itemRepository.fetchAllItems();
	}
	
	public List<Item> updateItems (List<Item> items) {
		itemRepository.storeItems(items);
		return itemRepository.fetchAllItems();
	}

	public List<Item> replaceItems (List<Item> items) {
		itemRepository.deleteItems(itemRepository.fetchAllItems());
		itemRepository.storeItems(items);
		return itemRepository.fetchAllItems();
	}
	
	public void deleteItems(List<Item> items) {
		itemRepository.deleteItems(items);
	}
	

}
