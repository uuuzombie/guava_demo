package com.sky.demo.base.supplier;


import org.junit.Test;


public class ComposedPredicateSupplierTest {

    private ComposedPredicateSupplier supplier = new ComposedPredicateSupplier();

    @Test
    public void test_ComposedPredicateSupplier(){
        supplier.get();
    }
}
