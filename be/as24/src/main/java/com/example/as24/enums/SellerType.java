package com.example.as24.enums;

public enum SellerType {
    PRIVATE("private"),
    DEALER("dealer"),
    OTHER("other");

    private final String seller;

    SellerType(final String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return seller;
    }
}
