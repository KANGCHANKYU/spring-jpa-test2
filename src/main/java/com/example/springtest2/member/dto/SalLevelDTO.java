package com.example.springtest2.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SalLevelDTO
{
    private String salLevel;

    private int minSal;

    private int maxSal;

    private List<EmployeeDTO> employee = new ArrayList<>();

}
