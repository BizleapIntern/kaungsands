package com.me.ds.loader;

import com.me.commons.domain.Company;
import com.me.commons.domain.exception.ServiceUnavailableException;

import java.io.IOException;
import java.util.List;

public interface CompanySaver {

    public void savePass1() throws ServiceUnavailableException, IOException;
    public void setCompanyList(List<Company> companyList);
}
