package org.example.sms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class OrderDetails {
    private String Itemid;
    private String oid;
    private int qty;
    private double amount;
}
