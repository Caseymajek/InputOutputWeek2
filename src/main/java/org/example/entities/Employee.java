package org.example.entities;

import lombok.Data;
import org.example.enums.Ethnic;
import org.example.enums.Gender;

import java.time.LocalDate;

@Data
public class Employee {
    private String fullName;
    private String employeeId;
    private String jobTitle;
    private String department;
    private String businessUnit;
    private Gender gender;
    private Ethnic ethnicity;
    private Integer age;
    private LocalDate hireDate;


}
