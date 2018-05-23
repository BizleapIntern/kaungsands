package com.me.ds.service.dao;

import com.me.commons.domain.Company;
import com.me.commons.domain.exception.ServiceUnavailableException;

public interface CompanyDao extends AbstractDao<Company, String> {
    public void save(Company company) throws ServiceUnavailableException;
}
