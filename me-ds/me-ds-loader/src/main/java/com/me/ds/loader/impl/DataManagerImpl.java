package com.me.ds.loader.impl;

import com.me.commons.domain.Company;
import com.me.commons.domain.Employee;
import com.me.commons.domain.exception.ServiceUnavailableException;
import com.me.ds.loader.AssociationMapper;
import com.me.ds.loader.CompanySaver;
import com.me.ds.loader.DataLoader;
import com.me.ds.loader.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("dataManager")
public class DataManagerImpl implements DataManager {
    List<Employee> employeeList;
    List<Company> companyList;

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private AssociationMapper associationMapper;

    @Autowired
    private CompanySaver companySaver;

    public void load() throws IOException, ServiceUnavailableException {
        //load the data
        dataLoader.loadData();
        //build the association
        associationMapper.buildAssociations();
        companySaver.setCompanyList(companyList);
        companySaver.savePass1();
    }

    public void print() {
        for(Employee employee:employeeList) {
            System.out.println(employee);
        }
        for(Company company:companyList) {
            System.out.println(company);
        }
    }

    @Override
    public List<Employee> getEmployeeList() {
        if(employeeList==null)
            this.employeeList=new ArrayList<Employee>();
        return employeeList;
    }

    @Override
    public List<Company> getCompanyList() {
        if(companyList==null)
            this.companyList=new ArrayList<Company>();
        return companyList;
    }
}
