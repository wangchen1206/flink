package com.flink.flinksource;

/**
 * @Author: cc
 * @Date: 2019/11/1 15:17
 */
public class Foo {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Foo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Foo() {
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
