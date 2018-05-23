package com.me.ds.service;

import com.me.commons.domain.Company;
import com.me.commons.domain.enums.ObjectFullnessLevel;
import com.me.commons.domain.exception.ServiceUnavailableException;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    public List<Company> findByCompanyBoId(String boId)throws ServiceUnavailableException;
    public List<Company> findByCompanyBoId(String boId, ObjectFullnessLevel objectFullnessLevel)throws ServiceUnavailableException;
    public Company findByCompanyBoIdSingle(String boId)throws ServiceUnavailableException;
    public void saveCompany(Company company) throws IOException, ServiceUnavailableException;
    public List<Company> getAllCompany()throws ServiceUnavailableException;
}
