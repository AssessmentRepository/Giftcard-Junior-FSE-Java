package com.giftcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giftcard.entitys.GiftCardOrderDetails;
import com.giftcard.entitys.Role;
import com.giftcard.entitys.User;
import com.giftcard.services.GiftCardOrderService;
import com.giftcard.services.UserService;
import com.giftcard.utility.TokenDetails;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {
	@Autowired(required = true)
	private GiftCardOrderService giftCardOrderService;
	@Autowired(required = true)
	private UserService userService;
	
	@Autowired
	private TokenDetails tokenDetails;

	@Autowired
	private User user;
	@Autowired
	private GiftCardOrderDetails giftCardOrderDetails;
	
	@GetMapping(value = "/User")
	public ResponseEntity<?> getByUsername(@RequestHeader("Authorization") String token,
			@RequestParam String userName) {
		return new ResponseEntity<>(userService.getByUsername(userName), HttpStatus.OK);
	}
	
	@PostMapping(value = "/User")
	public  ResponseEntity<Boolean> register(@RequestHeader("Authorization") String token,
			@RequestBody User user) {
			tokenDetails.validateUser(token, Role.Buyer.toString());
			return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
		}
	@PostMapping(value = "/User")
	public  ResponseEntity<Boolean> login(@RequestHeader("Authorization") String token,
			@RequestParam String userName,String password) {
			tokenDetails.validateUser(token, Role.Buyer.toString());
			return new ResponseEntity<>(userService.login(userName, password), HttpStatus.OK);
		}
	@PostMapping(value = "/User")
	public  ResponseEntity<Boolean> resetPassword(@RequestHeader("Authorization") String token,
			@RequestParam String userName,String password) {
			tokenDetails.validateUser(token, Role.Buyer.toString());
			return new ResponseEntity<>(userService.resetPassword(userName, password), HttpStatus.OK);
		}
	
	@PostMapping(value = "/deleteOrderById")
	public  ResponseEntity<Boolean> deleteOrderById(@RequestHeader("Authorization") String token,
			@RequestParam String orderId) {
			tokenDetails.validateUser(token, Role.Buyer.toString());
			return new ResponseEntity<>(userService.deleteOrderById(orderId), HttpStatus.OK);
		}
	
	@PostMapping(value = "/sendGiftcard")
	public  ResponseEntity<Boolean> sendGiftcard(@RequestHeader("Authorization") String token,
			@RequestParam String emailId) {
			tokenDetails.validateUser(token, Role.Buyer.toString());
			return new ResponseEntity<>(userService.sendGiftcard(emailId), HttpStatus.OK);
		}
	@PostMapping(value = "/saveUser")
	public  ResponseEntity<Boolean> saveUser(@RequestHeader("Authorization") String token,
			@RequestBody User user) {
			tokenDetails.validateUser(token, Role.Buyer.toString());
			return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
		}

}
