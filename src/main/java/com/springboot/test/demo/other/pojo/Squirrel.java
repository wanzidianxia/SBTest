package com.springboot.test.demo.other.pojo;

import com.springboot.test.demo.chapters3.pojo.definition.Animal;

public class Squirrel implements Animal {
    @Override
    public void use() {
        System.out.println("松鼠可以采集松果");
    }
}
