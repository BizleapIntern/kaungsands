package com.me.ds.service;

import com.me.commons.domain.Employee;
import com.me.commons.domain.exception.ServiceUnavailableException;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findByEmployeeBoId(String boId)throws ServiceUnavailableException;
    public Employee findByEmployeeBoIdSingle(String boId)throws ServiceUnavailableException;
    public void saveEmployee(Employee employee)throws ServiceUnavailableException;
    public List<Employee> getAllEmployee()throws ServiceUnavailableException;
    public void hibernateInitializeEmployeeList(List<Employee>employees)throws ServiceUnavailableException;
}
