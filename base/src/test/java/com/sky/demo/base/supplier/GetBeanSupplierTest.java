package com.sky.demo.base.supplier;


import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.sky.demo.base.model.City;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanSupplierTest {

    @Test
    public void test_getBean(){

        Supplier<City> global = Suppliers.memoize(new Supplier<City>() {
            ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

            @Override
            public City get() {
                return (City) context.getBean("global");
            }
        });

        System.out.println(global.get());
    }
}
