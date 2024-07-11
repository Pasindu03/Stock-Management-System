package org.example.sms.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Invoice {
    private String id;
    private String date;
    private String supid;
    private double amount;
}
