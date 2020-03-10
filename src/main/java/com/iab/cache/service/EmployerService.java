package com.iab.cache.service;

import com.iab.cache.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class EmployerService {

    @Autowired
    private CacheManager cacheManager;

    @CachePut(value = "employeeCache")
    public Employee createOrUpdateEmployee(Long id){
        return new Employee(id, "first"+id, "lastname"+id);
    }

    @Cacheable(value = "employeeCache")
    public Employee getEmployee(Long id){
        return null;
    }

    @CacheEvict(value = "employeeCache")
    public boolean deleteEmployee(Long id){
        return true;
    }

    @CacheEvict(value = "employeeCache", allEntries = true)
    public boolean deleteAllEmployes(){
        return true;
    }

    public Map<Long, Employee> getAllEmployees(){
        Map<Long, Employee> employeeMap = new HashMap<>();
        Iterator<javax.cache.Cache.Entry> employeeCaches = ((javax.cache.Cache)cacheManager.getCache("employeeCache").getNativeCache()).iterator();
        while (employeeCaches.hasNext()){
            javax.cache.Cache.Entry entry = employeeCaches.next();
            employeeMap.put((Long) entry.getKey(), (Employee)entry.getValue());
        }

        return employeeMap;
    }
}
