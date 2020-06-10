package com.giftcard.services;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Add;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.entitys.GiftCardOrderDetails;
import com.giftcard.entitys.User;



public interface GiftCardOrderService {
    /**
     * 
     * @return list of gift orders
     */
	List<GiftCardOrderDetailsDTO> getAllOrderDetails();

	/**
	 * 
	 * @param giftCardOrderDetails
	 * @return boolean true for successfully saving
	 */
	public Boolean saveGiftCardOrderDetail(GiftCardOrderDetailsDTO giftCardOrderDetails);
	
	public Boolean updateStatus(Boolean status);
	
	public void addGiftCards(GiftCardOrderDetails giftCardOrderDetails);
	
	public Boolean deleteGiftCards(GiftCardOrderDetails giftCardOrderDetails);
	
	public Boolean updateGiftCards(GiftCardOrderDetails giftCardOrderDetails);
	
	public void addCategory(String category);
	
	public boolean deleteCategory(String category);
	
	public boolean updateCategory(String category);
	
	public void getCommissionReport(String category);
	
	
	/**
     * 
     * @return list of undelivered gift orders
     */
	
	List<GiftCardOrderDetailsDTO> getAllUndeliveredGiftCards();

	List<User> getAllUsers();

}
