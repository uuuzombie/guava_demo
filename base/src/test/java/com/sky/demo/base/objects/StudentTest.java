package com.sky.demo.base.objects;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by rg on 15/7/11.
 */
public class StudentTest {

    Student student0, student1, student2, student3;

    @Before
    public void setUp() {
        student0 = new Student("peida", 23, 80);
        student1 = new Student("aida", 23, 36);
        student2 = new Student("jerry", 24, 90);
        student3 = new Student("peida", 23, 80);
    }

    @Test
    public void test_equals() {

        System.out.println("==========equals===========");
        System.out.println(student0.equals(student1));
        System.out.println(student0.equals(student2));
        System.out.println(student0.equals(student3));
    }

    @Test
    public void test_hashCode() {

        System.out.println("==========hashCode===========");
        System.out.println(student0.hashCode());
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());

    }

    @Test
    public void test_toString() {

        System.out.println("==========toString===========");
        System.out.println(student0.toString());
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

    }

    @Test
    public void test_compareTo(){

        System.out.println("==========compareTo===========");
        System.out.println(student0.compareTo(student1));       //0-1
        System.out.println(student0.compareTo(student2));       //0-2
        System.out.println(student2.compareTo(student1));       //2-1
        System.out.println(student2.compareTo(student0));       //2-0
    }
}
