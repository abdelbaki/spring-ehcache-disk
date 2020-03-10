package com.iab.cache.controller;

import com.iab.cache.model.Employee;
import com.iab.cache.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @RequestMapping(value = "/createEmployee", method = RequestMethod.PUT)
    public void createEmployee() {
        employerService.createOrUpdateEmployee((long) UUID.randomUUID().hashCode());
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public Employee getEmployee(Long id) {
        return employerService.getEmployee(id);
    }

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public Map<Long, Employee> getAllEmployees() {
        return employerService.getAllEmployees();
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public void deleteEmployee(Long idEmployee) {
        employerService.deleteEmployee(idEmployee);
    }

    @RequestMapping(value = "/deleteAllEmployes", method = RequestMethod.DELETE)
    public void deleteAllEmployes() {
        employerService.deleteAllEmployes();
    }




}