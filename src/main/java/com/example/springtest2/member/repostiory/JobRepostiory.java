package com.example.springtest2.member.repostiory;

import com.example.springtest2.member.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepostiory extends JpaRepository<Job,String >
{
    @Query(value = "SELECT j from Job j order by j.jobCode asc")
    List<Job> findAllCol();
}
