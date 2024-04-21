package com.favour.demo2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order extends Product{
    private int orderId;
    private int uId;
    private int quantity;
    private String date;
    public Order(){

    }

    public Order(int orderId, int uId, int quantity, String date) {
        this.orderId = orderId;
        this.uId = uId;
        this.quantity = quantity;
        this.date = date;
    }

    public Order(int uId, int quantity, String date) {
        this.uId = uId;
        this.quantity = quantity;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", uId=" + uId +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }
}
