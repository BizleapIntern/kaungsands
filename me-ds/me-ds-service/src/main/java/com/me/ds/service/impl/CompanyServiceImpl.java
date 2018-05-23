package com.me.ds.service.impl;

import com.me.commons.domain.Company;
import com.me.commons.domain.enums.EntityType;
import com.me.commons.domain.enums.ObjectFullnessLevel;
import com.me.commons.domain.exception.ServiceUnavailableException;
import com.me.ds.service.CompanyService;
import com.me.ds.service.EmployeeService;
import com.me.ds.service.dao.CompanyDao;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companyService")
@Transactional(readOnly = true)
public class CompanyServiceImpl extends AbstractServiceImpl implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeService employeeService;

    @Override
    public List<Company> findByCompanyBoId(String boId) throws ServiceUnavailableException {
        String queryStr = "select company from Company company where company.boId=:dataInput";
        List<Company> companyList = companyDao.findByString(queryStr, boId);
        hibernateInitializeCompanyList(companyList);
        return companyList;
    }

    public List<Company> findByCompanyBoId(String boId, ObjectFullnessLevel objectFullnessLevel)throws ServiceUnavailableException {
        String queryStr = "select company from Company company where company.boId=:dataInput";
        List<Company> companyList = companyDao.findByString(queryStr, boId);
        switch (objectFullnessLevel) {
            case SUMMARY:
                return companyList;
            default:
        }
        hibernateInitializeCompanyList(companyList);
        return companyList;
    }

    @Override
    public Company findByCompanyBoIdSingle(String boId) throws ServiceUnavailableException {
        List<Company> companyList = findByCompanyBoId(boId);
        if (!CollectionUtils.isEmpty(companyList)) {
            return companyList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveCompany(Company company) throws ServiceUnavailableException {
        if (company.isBoIdRequired()) {
            company.setBoId(getNextBoId());
        }
        companyDao.save(company);
    }

    @Override
    public List<Company> getAllCompany() throws ServiceUnavailableException {
        List<Company> companyList = companyDao.getAll("From Company company");
        hibernateInitializeCompanyList(companyList);
        return companyList;
    }

    @Override
    public long getCount() {
        return companyDao.getCount("select count(comp) from Company comp");
    }

    public String getNextBoId() {
        return getNextBoId(EntityType.COMPANY);
    }

    public void hibernateInitializeCompanyList(List<Company> companyList) throws ServiceUnavailableException {
        for (Company company : companyList)
            hibernateInitializeCompany(company);
    }

    public void hibernateInitializeCompany(Company company) throws ServiceUnavailableException {
        employeeService.hibernateInitializeEmployeeList(company.getEmployeeList());
    }
}
