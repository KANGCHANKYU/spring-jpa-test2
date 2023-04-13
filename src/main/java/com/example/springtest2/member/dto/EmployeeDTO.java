package com.example.springtest2.member.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class EmployeeDTO
{
    private String empId;

    private String empName;
    private String empNo;

    private String email;
    private String phone;

    private DepartmentDTO department;

    private JobDTO job;

    private SalLevelDTO salLevel;

    private int salry;

    private Double bonus;

    private String menagerId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entDate;

    private String entYn;

}
