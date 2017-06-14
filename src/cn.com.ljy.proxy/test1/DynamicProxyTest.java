package cn.com.ljy.proxy.test1;

import java.lang.reflect.Proxy;

/**
 * Created by wb-ljy189959 on 2017/5/16.
 * 动态代理测试类
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        //创建具体类ClassA的处理对象
        Invoker invoker1 = new Invoker(new ClassA());
        //获得具体类ClassA的代理
        AbstractClass ac1 = (AbstractClass)Proxy.newProxyInstance(AbstractClass.class.getClassLoader(),
            new Class[] {AbstractClass.class}, invoker1);
        System.out.println(ac1.getClass().getName());
        //调用ClassA的show方法。
        ac1.show();

        //创建具体类ClassB的处理对象
        Invoker invoker2 = new Invoker(new ClassB());
        AbstractClass ac2 = (AbstractClass)Proxy.newProxyInstance(AbstractClass.class.getClassLoader(),
            new Class[] {AbstractClass.class}, invoker2);
        System.out.println(ac2.getClass().getName());
        //效果一样
        /*AbstractClass ac2 = (AbstractClass)Proxy.newProxyInstance(invoker2.getClass().getClassLoader(),
            new Class[] {AbstractClass.class}, invoker2);*/
        ac2.show();

    }
}
