package com.exam.repositories;
import com.exam.models.Emp_Normal;
import com.exam.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpNormalRepository extends JpaRepository<Emp_Normal, Long> {
}
