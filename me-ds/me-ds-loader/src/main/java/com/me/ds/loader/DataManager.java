package com.me.ds.loader;

import com.me.commons.domain.Company;
import com.me.commons.domain.Employee;
import com.me.commons.domain.exception.ServiceUnavailableException;

import java.io.IOException;
import java.util.List;

public interface DataManager {
    public void load() throws IOException, ServiceUnavailableException;
    public void print();
    public List<Employee> getEmployeeList();
    public List<Company> getCompanyList();
}
