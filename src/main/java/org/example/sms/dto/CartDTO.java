package org.example.sms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CartDTO {
    String item_code;
    Integer item_qty;
    Double unit_price;

}
