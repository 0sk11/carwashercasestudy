package com.sk11.Customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class OrderModel {
    @Id
    private String id;
    private String customerName;
    private String customerEmail;
    private String washerName;
    private String washerEmail;
    private String promoCode;
    private String customerPlace;
    private String customerAddress;
    private String carType;
    private String addon;
    private double washcost;
    private double promoprice;
    private double addOnCost;
    private String date;
    private String time;
}
