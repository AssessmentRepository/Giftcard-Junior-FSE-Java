package com.giftcard.repos;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.giftcard.entitys.GiftCardOrderDetails;

public interface GiftcardRepository extends MongoRepository<GiftCardOrderDetails, String>  {

}
