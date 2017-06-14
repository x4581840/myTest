package cn.com.ljy.thisAndSupper.test1;

/**
 * Created by wb-ljy189959 on 2017/5/16.
 */
public class City extends Country{
      String name;

     @Override
     public void value() {
        name = "Shanghai";
        //super.value();      //调用父类的方法
        System.out.println(name);
        System.out.println(super.name); //如果没有super.value()，则打印null
    }

    public static void main(String[] args) {
        City c=new City();
        c.value();
    }
}
