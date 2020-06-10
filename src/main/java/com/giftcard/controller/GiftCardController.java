package com.giftcard.controller;

import java.util.List;

import javax.validation.Valid;

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


import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.entitys.GiftCardOrderDetails;
import com.giftcard.entitys.Role;
import com.giftcard.entitys.User;
import com.giftcard.services.GiftCardOrderService;
import com.giftcard.services.UserService;
import com.giftcard.utility.TokenDetails;

@RestController
@CrossOrigin
@RequestMapping("/GiftCardOrderDetails")
public class GiftCardController {

	@Autowired
	private GiftCardOrderService giftCardOrderService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenDetails tokenDetails;

	@PostMapping(value = "/addGiftCardOrder")
	public ResponseEntity<Boolean> addGiftOrder(@RequestBody @Valid GiftCardOrderDetailsDTO giftCardOrderDetails) {

		Boolean value = giftCardOrderService.saveGiftCardOrderDetail(giftCardOrderDetails);
		if (value) {
			return new ResponseEntity<Boolean>(value, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(value, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping(value = "/viewAllOrders")
	public ResponseEntity<List<GiftCardOrderDetailsDTO>> viewAllOrders() {
		return new ResponseEntity<List<GiftCardOrderDetailsDTO>>(giftCardOrderService.getAllOrderDetails(),
				HttpStatus.OK);
	}
	@PostMapping(value = "/updateStatus")
	public  ResponseEntity<Boolean> updateStatus(@RequestHeader("Authorization") String token,
			@RequestParam Boolean status) {
			tokenDetails.validateUser(token, Role.Admin.toString());
			return new ResponseEntity<>(giftCardOrderService.updateStatus(status), HttpStatus.OK);
		}
	@PostMapping(value = "/updateCategory")
	public  ResponseEntity<Boolean> updateCategory(@RequestHeader("Authorization") String token,
			@RequestParam String category) {
			tokenDetails.validateUser(token, Role.Admin.toString());
			return new ResponseEntity<>(giftCardOrderService.updateCategory(category), HttpStatus.OK);
		}
	@GetMapping(value = "/User")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(giftCardOrderService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllUndeliveredGiftCards")
	public ResponseEntity<List<GiftCardOrderDetailsDTO>> getAllUndeliveredGiftCards() {
		return new ResponseEntity<>(giftCardOrderService.getAllUndeliveredGiftCards(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCommissionReport")
	public ResponseEntity<?> getCommissionReport(@RequestHeader("Authorization") String token,
	@RequestParam String category) {
		tokenDetails.validateUser(token, Role.Admin.toString());
		return null;
	}
	@PostMapping(value = "/deleteCategory")
	public  ResponseEntity<Boolean> deleteCategory(@RequestHeader("Authorization") String token,
			@RequestParam String category) {
			tokenDetails.validateUser(token, Role.Admin.toString());
			return new ResponseEntity<>(giftCardOrderService.deleteCategory(category), HttpStatus.OK);
		}

	
	@PostMapping(value = "/deleteGiftCards")
	public  ResponseEntity<Boolean> deleteGiftCards(@RequestHeader("Authorization") String token,@RequestBody GiftCardOrderDetails giftCardOrderDetails){
			tokenDetails.validateUser(token, Role.Admin.toString());
			return new ResponseEntity<Boolean>(giftCardOrderService.deleteGiftCards(giftCardOrderDetails), HttpStatus.OK);
		}
	@PostMapping(value = "/updateGiftCards")
	public  ResponseEntity<Boolean> updateGiftCards(@RequestHeader("Authorization") String token,
			@RequestBody GiftCardOrderDetails giftCardOrderDetails){
			tokenDetails.validateUser(token, Role.Admin.toString());
			return new ResponseEntity<>(giftCardOrderService.updateGiftCards(giftCardOrderDetails), HttpStatus.OK);
		}
	}