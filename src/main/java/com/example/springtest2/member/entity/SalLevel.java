package com.example.springtest2.member.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SAL_GRADE")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SalLevel
{
    @Id @Column(name = "SAL_LEVEL")
    private String salLevel;

    @Column(name = "MIN_SAL")
    private int minSal;

    @Column(name = "MAX_SAL")
    private int maxSal;

    @OneToMany(mappedBy = "salLevel")
    private List<Employee> employee = new ArrayList<>();

}
