package org.example.sms.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Item {
    String itemCode;
    String itemName;
    double sellPrice;
    double getPrice;
    String itemType;
    String supplier;
    int quantity;
}
