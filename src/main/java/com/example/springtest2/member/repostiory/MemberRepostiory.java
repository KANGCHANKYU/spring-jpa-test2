package com.example.springtest2.member.repostiory;

import com.example.springtest2.member.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberRepostiory extends JpaRepository<Employee,String>
{
    @Query(value = "SELECT * FROM EMPLOYEE WHERE DEPT_CODE = ? ORDER BY EMP_ID ASC", nativeQuery = true)
    public List<Employee> searchDeptId(String code);

    @Query(value = "SELECT e FROM Employee e WHERE e.job.jobCode = :code ORDER BY e.empId ASC")
    public List<Employee> searchJobCode(@Param("code") String code);

    List<Employee> findByEmpId(String code);
}
