package com.example.springtest2.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Job")
@Table(name = "JOB")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Job
{
    @Id @Column(name = "JOB_CODE")
    private String jobCode;

    @Column(name = "JOB_NAME")
    private String jobName;

    @OneToMany(mappedBy = "job")
    private List<Employee> employee = new ArrayList<>();

}
