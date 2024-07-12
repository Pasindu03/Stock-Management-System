package org.example.sms.tm;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTM {
    private String id;
    private String name;
    private String contact;
    private String address;
    private String nic;

}
