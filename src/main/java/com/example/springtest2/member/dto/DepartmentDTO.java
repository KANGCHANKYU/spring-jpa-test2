package com.example.springtest2.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class DepartmentDTO
{
    private String deptId;

    private String deptTitle;

    private String locationId;

}
