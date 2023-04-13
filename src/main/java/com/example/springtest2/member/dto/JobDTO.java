package com.example.springtest2.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class JobDTO
{
    private String jobCode;

    private String jobName;

    private List<EmployeeDTO> employee = new ArrayList<>();

}
