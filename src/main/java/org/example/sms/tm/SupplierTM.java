package org.example.sms.tm;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierTM {
    private String id;
    private String supplierName;
    private String supplierCompany;
    private String contact;
}
