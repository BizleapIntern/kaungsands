package com.me.ds.service.dao.impl;

import com.me.commons.domain.Employee;
import com.me.commons.domain.exception.ServiceUnavailableException;
import com.me.ds.service.dao.EmployeeDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, String> implements EmployeeDao {

    protected EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Override
    public void save(Employee employee) throws ServiceUnavailableException {
        saveOrUpdate(employee);
    }
}
