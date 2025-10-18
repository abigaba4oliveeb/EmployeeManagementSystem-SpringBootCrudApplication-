package com.employeeManagement.crud.dao;

import com.employeeManagement.crud.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    //returns a list of employees
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);


}
