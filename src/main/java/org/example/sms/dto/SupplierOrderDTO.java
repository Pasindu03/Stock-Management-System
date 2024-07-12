package org.example.sms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SupplierOrderDTO {
    private String sup_order_id;
    private String date;
    private String supplierid;
    private double amount;
    private String status;
}
