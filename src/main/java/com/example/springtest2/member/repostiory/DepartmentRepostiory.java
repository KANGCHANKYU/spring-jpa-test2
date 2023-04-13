package com.example.springtest2.member.repostiory;

import com.example.springtest2.member.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepostiory extends JpaRepository<Department,String>
{
    @Query(value = "select d from Department d order by d.deptId asc")
    List<Department> findAllCol();
}
