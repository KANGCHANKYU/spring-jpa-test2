package com.example.springtest2.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Employee")
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Employee
{
    @Id @Column(name = "EMP_ID")
    private String empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "EMP_NO")
    private String empNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "DEPT_CODE")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "JOB_CODE")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "SAL_LEVEL")
    private SalLevel salLevel;

    @Column(name = "SALARY")
    private int salry;

    @Column(name = "BONUS")
    private Double bonus;

    @Column(name = "MANAGER_ID")
    private String menagerId;

    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    @Column(name = "ENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entDate;

    @Column(name = "ENT_YN")
    private String entYn;

}
