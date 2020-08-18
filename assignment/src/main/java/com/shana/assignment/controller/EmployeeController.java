package com.shana.assignment.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.shana.assignemt.exception.IdNotFoundException;
import com.shana.assignment.dao.EmployeeRepository;
import com.shana.assignment.model.Employee;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @ApiOperation(tags = "/api", value = "assignment", httpMethod = "POST", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })

    @RequestMapping("/post")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        try {
            Employee employee1 = employeeRepository.save(employee);
            return new ResponseEntity<>(employee1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/get")
    public ResponseEntity<Employee> getAll(Employee employee) {
        List<Employee> empList = employeeRepository.findAll();

        LOGGER.info("Get Operation Success" + empList);

        return new ResponseEntity(empList, HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable("id") Long Id) {

       Optional<Employee> employeeId = employeeRepository.findById(Id);
       return employeeId.get();

  /*      Optional<Employee> getId = employeeRepository.findById(Id);
        if (getId.isPresent()) {
            return new ResponseEntity<>(getId.get(), HttpStatus.OK);

        } else {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new IdNotFoundException("id-" + Id);*/
        }


    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {

        Optional<Employee> updateEmp = employeeRepository.findById(id);

        if (updateEmp.isPresent()) {
            Employee employee1 = updateEmp.get();
            employee1.setDescription(employee.getDescription());
            employee1.setTitle(employee.getTitle());

            return new ResponseEntity<>(employeeRepository.save(employee1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        try {
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (IdNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
		
	
