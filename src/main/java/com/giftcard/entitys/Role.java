package com.giftcard.entitys;


public enum Role {
    Admin, Buyer, Seller;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
