package com.giftcard.services;

import java.util.Optional;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.entitys.ShippingAddress;
import com.giftcard.entitys.User;
import com.giftcard.security.model.token.RefreshToken;



public interface UserService {

	
public boolean register(User user);
public boolean login(String userName,String password);
public boolean resetPassword(String userName,String password);
public void placeOrder(ShippingAddress shippingAddress,Long giftAmount);
public boolean sendGiftcard(String emailId);
Optional<User> getByUsername(String username);
Boolean saveUser(User user);
void blockOrUnblockUser(String userName, Boolean value);
boolean deleteOrderById(String orderId);
}
