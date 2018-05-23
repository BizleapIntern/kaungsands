package com.me.ds.standalone.impl.test;

import com.me.ds.loader.DataManager;
import com.me.ds.service.CompanyService;
import com.me.ds.service.EmployeeService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml","classpath:/hibernateContext.xml"})
@PropertySource({"classpath:log4j.properties", "classpath:/application.properties"})
@ComponentScan({"com.bizleap.training.ds.loader"})
public class ServiceTest {

    @Autowired
    @Qualifier("dataManager")
    protected DataManager dataManager;

    //@Autowired
    //@Qualifier("userService")
    //protected UserService userService;

    //@Autowired
    //public DataService dataService;

    @Autowired
    protected CompanyService companyService;

    @Autowired
    protected EmployeeService employeeService;

}
