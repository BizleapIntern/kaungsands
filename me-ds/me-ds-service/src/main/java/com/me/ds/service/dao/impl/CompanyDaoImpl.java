package com.me.ds.service.dao.impl;

import com.me.commons.domain.Company;
import com.me.commons.domain.exception.ServiceUnavailableException;
import com.me.ds.service.dao.CompanyDao;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl extends AbstractDaoImpl<Company, String> implements CompanyDao {

    protected CompanyDaoImpl() {
        super(Company.class);
    }

    @Override
    public void save(Company company) throws ServiceUnavailableException {
        saveOrUpdate(company);
    }
}
