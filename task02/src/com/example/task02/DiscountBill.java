package com.example.task02;

public class DiscountBill extends Bill{
    private final int Discount;

    public DiscountBill(int discount){
        Discount = discount;
    }

    public int getDiscount(int discount){
        return discount;
    }

    public long AbsoluteDiscount(){
        return super.getPrice() * (Discount / 100);
    }

    public long getPrice(){
       return super.getPrice() - super.getPrice() * (Discount / 100);
    }
}
