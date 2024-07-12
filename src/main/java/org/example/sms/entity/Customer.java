package org.example.sms.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer {
    String id;
    String name;
    String address;
    String contact;
    String NIC;
}
