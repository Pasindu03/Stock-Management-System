package org.example.sms.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ItemTM {
    String itemCode;
    String itemName;
    double sellPrice;
    double getPrice;
    String itemType;
    String supplier;
    int quantity;
}
