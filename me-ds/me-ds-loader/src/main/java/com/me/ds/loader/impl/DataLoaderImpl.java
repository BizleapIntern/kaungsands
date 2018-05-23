package com.me.ds.loader.impl;

import com.me.commons.domain.Company;
import com.me.commons.domain.Employee;
import com.me.ds.loader.DataLoader;
import com.me.ds.loader.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("dataLoader")
public class DataLoaderImpl implements DataLoader {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private FileLoaderImpl fileLoaderImpl;

    public void loadEmployee(String fileName) {
        try {
            fileLoaderImpl.start(fileName);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Employee employee;
        try {
            while(fileLoaderImpl.hasNext()) {
                try {
                    employee=Employee.parseEmployee(fileLoaderImpl.getLine());
                    if(employee!=null) {
                        dataManager.getEmployeeList().add(employee);
                    }
                }catch(Exception e){
                    fileLoaderImpl.error(e);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fileLoaderImpl.finish();
    }


    public void loadCompany(String fileName) {
        try {
            fileLoaderImpl.start(fileName);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Company company;
        try {
            while(fileLoaderImpl.hasNext()) {
                try {
                    company=Company.parseCompany(fileLoaderImpl.getLine());
                    if(company!=null) {
                        dataManager.getCompanyList().add(company);
                    }
                }catch(Exception e){
                    fileLoaderImpl.error(e);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fileLoaderImpl.finish();
    }

    @Override
    public void loadData() {
        loadEmployee("employee.txt");
        loadCompany("company.txt");
    }
}
