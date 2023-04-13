package com.example.springtest2.member.service;

import com.example.springtest2.member.dto.EmployeeDTO;
import com.example.springtest2.member.entity.Department;
import com.example.springtest2.member.entity.Employee;
import com.example.springtest2.member.entity.Job;
import com.example.springtest2.member.repostiory.DepartmentRepostiory;
import com.example.springtest2.member.repostiory.JobRepostiory;
import com.example.springtest2.member.repostiory.MemberRepostiory;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MemberService
{
    private final MemberRepostiory memberRepostiory;
    private final DepartmentRepostiory departmentRepostiory;
    private final JobRepostiory jobRepostiory;
    private final ModelMapper modelMapper;
    @PersistenceContext
    private EntityManager em;

    public MemberService(MemberRepostiory memberRepostiory , ModelMapper modelMapper,
                         DepartmentRepostiory departmentRepostiory , JobRepostiory jobRepostiory)
    {
        this.memberRepostiory = memberRepostiory;
        this.modelMapper = modelMapper;
        this.departmentRepostiory = departmentRepostiory;
        this.jobRepostiory = jobRepostiory;
    }

    public EmployeeDTO findById(String empId)
    {
        Employee emp = memberRepostiory.findById(empId).orElseThrow(IllegalAccessError::new);
        return modelMapper.map(emp, EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAll()
    {
        List<Employee> member = memberRepostiory.findAll();
        return member.stream().map(m -> modelMapper.map(m, EmployeeDTO.class)).collect(Collectors.toList());
    }

    public List<EmployeeDTO> serchFindMember(String code)
    {
        List<Employee> member = new ArrayList<>();
        if(code.contains("D") || code.contains("T"))
        {
            member = memberRepostiory.searchDeptId(code);
        }
        else if(code.contains("J"))
        {
            member = memberRepostiory.searchJobCode(code);
        }
        else
            member = memberRepostiory.findByEmpId(code);

        return member.stream().map(m -> modelMapper.map(m, EmployeeDTO.class)).collect(Collectors.toList());
    }

    public Map<String, Object> findCategory(int value)
    {
        Map<String,Object> m = new HashMap<>();
        switch (value)
        {
            case 1:
                List<Department> departments = departmentRepostiory.findAllCol();
                m.put("category",departments);
                break;
            case 2: List<Job> job = jobRepostiory.findAllCol();
                m.put("category",job);
                break;
        }
        return m;
    }

    @Transactional
    public void registMember(EmployeeDTO employee)
    {
        employee.setBonus(0.2);
        employee.setHireDate(new Date(System.currentTimeMillis()));
        employee.setEntYn("N");
        Employee newMember = modelMapper.map(employee,Employee.class);
        memberRepostiory.save(newMember);
    }

    @Transactional
    public void modifyMember(EmployeeDTO emp)
    {
        Employee member = memberRepostiory.findById(emp.getEmpId()).orElseThrow(IllegalAccessError::new);
        member.setEmpName(emp.getEmpName());
    }

    public void deleteMember(String code)
    {
        memberRepostiory.deleteById(code);
    }
}
