package com.sky.demo.base.objects;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * Created by rg on 15/7/11.
 */
public class Student implements Comparable<Student>{

    //以下equals()、hashCode()、toString()、compareTo()均未采用常规IDE生成的方法，采用Objects

    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    //采用Guava中的Objects ， 未采用IDE自动生成的equals()
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Student) {
            Student that = (Student) obj;
            return Objects.equal(name, that.name)
                    && Objects.equal(age, that.age)
                    && Objects.equal(score, that.score);
        }
        return false;
    }

    //采用Guava中Objects ，未采用IDE自动生成的hashCode()
    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }

    //采用Guava中Objects ，未采用IDE自动生成的toString()
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(name)
                .addValue(age)
                .addValue(score)
                .toString();
    }

    //采用Guava中的ComparisonChain ，未采用IDE自动生成的compareTo()
    @Override
    public int compareTo(Student o) {
        return ComparisonChain.start()
                .compare(name, o.name)
                .compare(age,o.age)
                .compare(score, o.score)
                .result();
    }
}
