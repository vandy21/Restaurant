package com.vann.RestaurantB.Dao;

import java.util.List;

import com.vann.RestaurantB.Model.Card;

public interface CardDao {
	public boolean saveupdate(Card card);

	public boolean delete(String cardId);

	public Card get(String cardId);
	public List<Card> getlistbyU_Id(String userId);
	
	public List<Card> list();


}
