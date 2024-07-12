package org.example.sms.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Supplier {
    private String id;
    private String supplierName;
    private String supplierCompany;
    private String contact;
}
