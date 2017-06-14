import java.util.HashMap;

import sun.applet.Main;

/**
 * Created by wb-ljy189959 on 2017/4/24.
 */
public class TestLong {

    /*public static void main(String[] args) {
        HashMap map = new HashMap<>(-1);
        //System.out.println("my first hello world");
        //HashMap map = new HashMap<>(15);
        //for (int i = 1; i<= 16;i++) {
        //    map.put(i,"test");
        //}
        //System.out.println(map.size());
    }*/

    /*public static void main(String[] args){
        StringBuffer s= new StringBuffer("good");
        StringBuffer s2=new StringBuffer("bad");
        test(s,s2);
        System.out.println(s);//9
        System.out.println(s2);//10
    }
    static void test(StringBuffer s,StringBuffer s2) {
        System.out.println(s);//1
        System.out.println(s2);//2
        s2=s;//3
        s=new StringBuffer("new");//4
        System.out.println(s);//5
        System.out.println(s2);//6
        s.append("hah");//7
        s2.append("hah");//8
    }*/

   /* public static void main(String[] args) {
        String str = "long"; //假设变量str保存的地址是0x10
        test(str);
        System.out.println(str); //输出long, 说明变量str保存的地址是0x10
    }

    static void test(String s) {
        System.out.println(s); //输出long, 说明变量s保存的地址也是0x10
        s+="append";
        System.out.println(s); //
        //s = "test";
        //System.out.println(s); //输出test, 说明变量s保存的地址不是0x10了
    }*/

    public static void changeEmployee(Employee employee) {
        employee = new Employee();
        employee.age = 1000;
    }

    public static void main(String[] args) {
        //Employee employee = new Employee();
        //employee.age = 100;
        //changeEmployee(employee);
        //System.out.println(employee.age); //100

        String s = "我是%s";
        System.out.println(String.format(s, "龙建勇"));

        Employee e = null;
        if(null != e) {
            System.out.println("hhhh");
        }
    }

}

class Employee {
   public int age;
}
