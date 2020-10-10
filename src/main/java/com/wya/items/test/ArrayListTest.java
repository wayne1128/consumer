package com.wya.items.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(2);
        Person p2 = new Person();
        p2.setAge(2);
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        doSomething(list);
        System.out.println(list.size());
    }

    public static void doSomething(List<Person> list){
        list.remove(0);
        list = null;
        System.out.println(list.size());
    }
}
