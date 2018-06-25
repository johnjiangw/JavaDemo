package com.john.javademo;

//import com.john.javademo.dao.MySqlHelper;
//import com.john.javademo.impl.IDB;

import com.john.javademo.net.UdpClient;


import java.net.InetAddress;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        //System.out.println("hello");
        /*交换值*/
       /* int a=10,b=20;
        a=a^b;
        b=b^a;
        a=a^b;
        System.out.println(String.format("a=%s b=%s",a,b));*/
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("请输入一个整数");
//        int a=scanner.nextInt();
//        System.out.println(String.format("%s 是%s",a,(a%2==0?"偶数":"奇数")));
//        System.out.println(((Object)a).getClass().toString());
//        System.out.println(getType(a));
//        System.out.println(getType(scanner));
//        String[] array={"123","abc","efg"};
//        for(String s :array)
//        {
//            System.out.println(s);
//        }
        /*乘法表*/
        /*for(int i=1;i<=9;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(String.format("%s*%s=%s\t",j,i,i*j));
            }
            System.out.println();
        }*/
        /*跳出整个循环*/
        /*int[][]arr={
                {1,3,5},
                {2,4,6},
        };
        No1:for(int[] is:arr)
        {
            for(int x :is)
            {
                System.out.print(x);
                if(x>4)
                {
                    break No1;
                }
            }
        }*/
        /*
        用for循环输出空心菱形
        */
        /*int len=11;
        for(int i=0;i<len/2+1;i++)
        {
            for(int j=len/2+1;j>i+1;j--)
            {
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++)
            {
                if(j==0||j==2*i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=len/2+1;i<len;i++)
        {
            for(int j=0;j<i-len/2;j++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<2*len-1-2*i;j++)
            {
                if(j==0||j==2*(len-i-1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }*/
        /*String s="1,2,3,4";
        String[]arr= s.split(",");
        for(String str:arr)
        {
            System.out.println(str);
        }*/
     /*   Integer[]arr={1,2,3,4};
//        Arrays.fill(arr,8);
        Arrays.sort(arr,Collections.reverseOrder());

        for(int x:arr)
        {
            System.out.println(x);
        }*/
        /*String s="abcdef";
        System.out.println(s.lastIndexOf(" "));*/
//        String s=" We are students ";
//        System.out.println(s.trim());
//        String s1="student";
//        String s2="student";
//        String s3="Student";
        /*String s1=new String("student");
        String s2=new String("student");
        String s3=new String("Student");
        String s4=s1;
        System.out.println(String.format("s1:%s     s2:%s   s3:%s   s4:%s",
                System.identityHashCode(s1),
                System.identityHashCode(s2),
                System.identityHashCode(s3),
                System.identityHashCode(s4)));
        System.out.println(String.format("s1==s2:%s",s1==s2));//判断内存地址是否一致
        System.out.println(String.format("s1==s3:%s",s1==s3));
        System.out.println(String.format("s1==s4:%s",s1==s4));
        System.out.println(String.format("s1 equals s2:%s",s1.equals(s2)));//比较值相等
        System.out.println(String.format("s1 equals s3:%s",s1.equals(s3)));
        System.out.println(String.format("s1 equalsIgnoreCase s3:%s",s1.equalsIgnoreCase(s3)));
        s2="abc";
        System.out.println(String.format("s1:%s     s2:%s   s3:%s   s4:%s",
                System.identityHashCode(s1),
                System.identityHashCode(s2),
                System.identityHashCode(s3),
                System.identityHashCode(s4)));*/
/*        Date dt=new Date();
        System.out.println(dt.toString());
        System.out.println(String.format("%tY-%tm-%td %tH:%tM:%tS %tL",dt,dt,dt,dt,dt,dt,dt));
        System.out.println(String.format("%tF %tT",dt,dt));*/
        /*String old="我爱java";
        char key='祁';
        String en=encrypt(old,key);
        System.out.println(String.format("加密后：%s",en));
        String de=encrypt(en,key);
        System.out.println(String.format("解密后：%s",de));*/
        //MySqlHelper dao=new MySqlHelper("http://1982.168.0.8",3306,"test","root","root");
        /*MySqlHelper obj =dao.Update();
        System.out.println(System.identityHashCode(obj));
        obj=obj.Remove();
        System.out.println(System.identityHashCode(obj));*/
       /* Circle c=new Circle(1);
        System.out.println(String.format("Type:%s   Area:%f",c.getName(),c.getArea()));
        Rectangle r=new Rectangle(2,1.1);
        System.out.println(String.format("Type:%s   Area:%f",r.getName(),r.getArea()));*/

       //Employee e=new Employee(2,"john",10);
       /* Employee e=new Employee();
        //HashMap map=new HashMap();
        Hashtable map=new Hashtable();
        map.put("id",20);
        map.put("name","test");
        map.put("age",50);
        Class<?>eClass=e.getClass();
        Field[] eFields=eClass.getDeclaredFields();
        for(Field f:eFields){
            System.out.println(f.getName());
        }
        //反射赋值
        try {
            for(Field f:eFields){
                Object obj=map.get(f.getName());
                if(obj!=null){
                    f.setAccessible(true);//可访问私有属性
                    f.set(e,obj);
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        //反射取值
        try {
            for(Field f:eFields){
                f.setAccessible(true);//可访问私有属性
                Object value=f.get(e);
                System.out.println(String.format("Name:%s   Type:%s     Value:%s",f.getName(),f.getType().getSimpleName(),value==null?"null":value.toString()));
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }*/
        /*Method[] methods=eClass.getDeclaredMethods();
        for (Method m:methods ) {
            System.out.println(String.format("Name:%s   Modifiers:%d",m.getName(),m.getModifiers()));

        }
        try {
            Class<?>classz=Class.forName("java.util.List");
            System.out.println(classz.getSimpleName());
            System.out.println("所有的泛型参数：");
            for (TypeVariable t:classz.getTypeParameters()) {
                System.out.println(t);
            }
            System.out.println("所有的属性：");
            for (Field f:classz.getFields()) {
                System.out.println(String.format("Field:%s      MModifiers:%s",f.getName(),Modifier.toString(f.getModifiers())));
            }
            System.out.println("所有的方法：");
            for (Method m:classz.getMethods()) {
                System.out.println(String.format("Method:%s     Modifiers:%s",m.getName(),Modifier.toString(m.getModifiers())));
            }
            System.out.println("所有实现的接口：");
            for (Type t:classz.getGenericInterfaces()) {
                System.out.println(String.format("Interface:%s",t));
                
            }
            System.out.println(String.format("继承自父类：%s",classz.getGenericSuperclass()));
            System.out.println("所有注释：");
            for (Annotation a:classz.getAnnotations()                 ) {
                System.out.println(a);
            }
        }
        catch (Exception ex){

        }*/
        /*try {
            Method mTest= eClass.getDeclaredMethod("compareTo",eClass);
            if(mTest!=null){
                int result=(int)mTest.invoke(e,new Employee(2,"张三",10));
                System.out.println(result);
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }*/


//        String[]array=new String[]{"1","2","3"};
//        e.test();
//        e.test(array);



        /*OutAndInnerClass c=new OutAndInnerClass();
        c.inner.innerTest(4);
        OutAndInnerClass.InnerClass i=c.new InnerClass();//实例化内部类
        c.test(5);

        System.out.println(OutAndInnerClass.StaticInnerClass.x);*/
        //Clock c=new Clock(1000,true);
        //c.start();
        //List<String> list=new List<String>();

        /*List array=new ArrayList();
        array.add("test");
        array.add("test");
        System.out.println(array);
        Set set=new HashSet();
        set.add("test");
        set.add("test");
        System.out.println(set);
        System.out.println(UUID.randomUUID().toString().replace("-",""));
        System.out.println("abcde".replace('a','b'));
        System.out.println(UUID.randomUUID().toString().replace('-',(char)32));*/
        //Employee e=new Employee(1,"test",12);
        //User u=new User();
        //User u=new User(2,"张三");
        //Employee e=new Employee();
       /* try {
            u=ReflectUtil.copyValueIgnoreCase(e,u,true);
            //e=ReflectUtil.copyValueIgnore(u,e,true);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("完成");*/
       //tcp客户端
       /*try {
           InetAddress serverAddress=InetAddress.getByName("192.168.0.8");
           InetAddress localAddress=InetAddress.getLocalHost();
           //SocketClient client=new SocketClient(serverAddress,3000);
           SocketClient client=new SocketClient(serverAddress,3000,5000);
           //SocketClient client=new SocketClient(serverAddress,3000,localAddress,5000);
           client.start();
           Scanner scan = new Scanner(System.in);
           System.out.println("输入消息内容：") ;
           String msg=scan.next();
           do{
               if(msg.equalsIgnoreCase("break")) {
                   client.stop();
                   break;
               }
               else
                   client.send(msg);
           }
           while((msg= scan.next())!=null);
       }
       catch (Exception e){
           e.printStackTrace();
       }*/
       //tcp服务端
       /*try
       {
           TcpServer server=new TcpServer(6000);
           server.start();
           Scanner scan = new Scanner(System.in) ;
           System.out.print("输入消息内容：") ;
           String msg =  scan.next();
           do{
               //server.send(msg,InetAddress.getByName("192.168.0.126"),);
                server.send(msg);
           } while((msg= scan.next())!=null);
       }
       catch (Exception e){
           e.printStackTrace();
       }*/
       //udp
        try
        {

            UdpClient client=new UdpClient(InetAddress.getByName("192.168.0.8"),5000);
            client.start();
            Scanner scan = new Scanner(System.in);
            System.out.println("输入消息内容：") ;
            String msg=scan.next();
            do{
                if(msg.equalsIgnoreCase("break")) {
                    client.stop();
                    break;
                }
                else
                    client.send(msg,InetAddress.getByName("192.168.0.126"),60001);
            }
            while((msg= scan.next())!=null);

        }catch (Exception e){
            e.printStackTrace();
        }
        /*MathOperation add=(int a,int b)->a+b;
        MathOperation add1=(a,b)->a+b;
        MathOperation add2=(a,b)->{System.out.println("hello");return a-b;};
        System.out.println(operation(10,5,add2));*/
    }
    interface MathOperation {
        int operation(int a, int b);
    }
    public static  int operation(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
   /* public static String encrypt(String value,char key){
        byte[]arr=value.getBytes();
        for(int i=0;i<arr.length;i++){
            arr[i]=(byte)(arr[i]^(int)key);
        }
        return new String(arr,0,arr.length);
    }*/

}

