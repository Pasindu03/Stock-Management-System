package org.example.sms.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDTO {
    private String id;
    private String name;
    private String address;
    private String jobRoll;
    private String contact;
    private double salary;
}
