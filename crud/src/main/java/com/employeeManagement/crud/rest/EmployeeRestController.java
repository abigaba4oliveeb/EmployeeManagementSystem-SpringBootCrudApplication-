package com.employeeManagement.crud.rest;

import com.employeeManagement.crud.dao.EmployeeDAO;
import com.employeeManagement.crud.entity.Employee;
import com.employeeManagement.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //quick and dirty: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //expose "/employees and return llist of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theEmployee, HttpStatus.OK);
    }

    //add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee theEmployee) {
        //also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        theEmployee.setId(0);
        
        Employee dbEmployee = employeeService.save(theEmployee);
        return new ResponseEntity<>(dbEmployee, HttpStatus.CREATED);
    }

    //add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return new ResponseEntity<>(dbEmployee, HttpStatus.OK);
    }

    //add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        
        //throw exception if null
        if (tempEmployee == null) {
            return new ResponseEntity<>("Employee id not found - " + employeeId, HttpStatus.NOT_FOUND);
        }
        
        employeeService.deleteById(employeeId);
        return new ResponseEntity<>("Deleted employee id - " + employeeId, HttpStatus.OK);
    }
}





