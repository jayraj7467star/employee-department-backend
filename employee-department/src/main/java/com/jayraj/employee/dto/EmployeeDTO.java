package com.jayraj.employee.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
    private String departmentId;
    private String departmentName;
}
