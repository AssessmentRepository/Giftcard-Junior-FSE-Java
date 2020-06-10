package com.giftcard.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("giftcarddetails")
 @Data
public class GiftCardOrderDetails {

	@Id
	private String orderId;

	private String buyerFirstName;

	private String buyerLastName;

	private String recipientFirstName;

	private String recipienLastName;

	private Long giftAmount;

	private String phoneNumber;

	private String email;
	private Boolean status=true;
    private String category;
	private ShippingAddress shippingAddress;

}