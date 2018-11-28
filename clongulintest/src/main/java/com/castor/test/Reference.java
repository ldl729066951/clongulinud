package com.castor.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Reference {


    public static void main(String[] args) {

        A a = new A("castor", 19);
        System.out.println(a.getAge());
        chage(a);
        System.out.println(a.getAge());

    }

    public static void chage(A a){
        a.setAge(20);
    }

}

@Getter
@Setter
@AllArgsConstructor
class A{
    private String name;
    private int age;
}