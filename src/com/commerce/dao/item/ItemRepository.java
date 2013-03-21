package com.commerce.dao.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.commerce.model.item.Item;

@Repository
public class ItemRepository {

	@Autowired
	private SqlSession sqlSession;

	
	public Item fetchItem(String styleColorNumber) {
		Map<String, String> criteriaMap = new HashMap<String, String>();
		criteriaMap.put("styleColorNumber", styleColorNumber);
		return sqlSession.selectOne("selectItems", criteriaMap);
	}

	public int updatePrice (Item item){
		return sqlSession.insert("insertOrUpdateItem", item);
	}

	public int deleteItem(String styleColorNumber) {
		return sqlSession.delete("deleteItem",styleColorNumber);
	}
	
	public void deleteItems (List<Item> items) {
		for (Item item : items) {
			deleteItem(item.getStyleColorNumber());
		}
	}
	
	public List<Item> fetchAllItems () {
		return sqlSession.selectList("selectAllItems");
	}
	
	public void storeItems (List<Item> items) {
		for (Item item : items) {
			updatePrice(item);
		}
	}
}
