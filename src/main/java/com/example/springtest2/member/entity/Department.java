package com.example.springtest2.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Department")
@Table(name = "DEPARTMENT")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class Department
{
    @Id @Column(name = "DEPT_ID")
    private String deptId;

    @Column(name = "DEPT_TITLE")
    private String deptTitle;

    @Column(name = "LOCATION_ID")
    private String locationId;

}
