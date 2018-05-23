package com.me.ds.standalone.impl.test;

import com.me.commons.domain.exception.ServiceUnavailableException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DataManagerImplTest extends ServiceTest{

    static Logger logger=Logger.getLogger(DataManagerImplTest.class);

    @Ignore
    @Test
    public void testLoad() throws IOException,ServiceUnavailableException {
        dataManager.load();

        assertNotNull(dataManager.getEmployeeList());
        assertTrue(CollectionUtils.isNotEmpty(dataManager.getEmployeeList()));
        assertEquals(8,dataManager.getEmployeeList().size());

        assertNotNull(dataManager.getCompanyList());
        assertTrue(CollectionUtils.isNotEmpty(dataManager.getCompanyList()));
        assertEquals(3,dataManager.getCompanyList().size());
    }

    @Ignore
    @Test
    public void testLoadFalse() {
        assertTrue(false);
    }

}
