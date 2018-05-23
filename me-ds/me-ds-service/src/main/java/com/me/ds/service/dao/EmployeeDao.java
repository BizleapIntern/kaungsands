package com.me.ds.service.dao;

import com.me.commons.domain.Employee;
import com.me.commons.domain.exception.ServiceUnavailableException;

public interface EmployeeDao extends AbstractDao<Employee, String> {
    public void save(Employee employee) throws ServiceUnavailableException;
}
