package com.john.javademo;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int age;
    public Employee(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public Employee(){}

    @Override
    public int compareTo(Employee o) {
        if(id>o.id)
            return 1;
        else if(id<o.id)
            return -1;
        return 0;
    }
    public void test(String... args){
        System.out.println("可变参数");
        for (String s:args) {
            System.out.println(s);
        }
    }

    public String toString(){
        return String.format("ID:%d     Name:%s     Age:%d",this.id,this.name,this.age);
    }
}
