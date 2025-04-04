package com.app.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// DTO (Data Transfer Object) for Employee entity
// This class is used to transfer data between the client and server
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;

}
