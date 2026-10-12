package com.purchase;

public class PurchaseCalculator {
    public static void main(String[] args) {

    }// main

    public static double calculateSubtotal(double price, int quantity){
        return price * quantity;
    }// calculateSubtotal

    public static boolean isValidPurchase(double price, int quantity){
        return price > 0 && quantity > 0;
    }// isValidPurchase

    public static double calculateDiscount(double subtotal){
        if(subtotal > 1000){
            return subtotal * 0.1;
        }
        return 0;
    }// calculateDiscount

    public static double calculateFinalPrice(double subtotal){
        return subtotal - calculateDiscount(subtotal);
    }// calculateFinalPrice

}// class PurchaseCalculator
