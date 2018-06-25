package com.john.javademo;

public class OutAndInnerClass {
    InnerClass inner=new InnerClass();
    private int num=10;
    private void outTest(){
        System.out.println("OutClass");
    }
    class InnerClass{
        private int num=0;
        void innerTest(int num){
            num++;//形参
            this.num++;//内部类的变量
            OutAndInnerClass.this.num++;//外部类的变量
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(OutAndInnerClass.this.num);
            //outTest();
        }
    }
    static class StaticInnerClass{
        static int x=100;
    }
    public void test(int x){
        //局部内部类
        class Test{
            int p=0;
            public Test(int p){
                this.p=p;
            }
            public void print() {
                System.out.println(p);
            }
        }
        Test t=new Test(5);
        t.print();
    }

}
