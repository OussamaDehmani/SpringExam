package com.exam.services;
import com.exam.models.Employee;
import org.springframework.stereotype.Service;
import java.util.List;



public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
