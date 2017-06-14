package cn.com.ljy.hessian.test1;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * Created by wb-ljy189959 on 2017/5/18.
 */
public class Client {
    interface Hello {
        String hello(Object name); //通
        //String hello(Object name, String name1); //不通，跟服务器的接口参数数量不一致
        //String hello(String name); //和服务器的接口名字和参数个数是一样的，可以调通
    }

    interface SumSay {
        String say(String msg);

        int sum(int a, int b);

        int sum(int a);

        int hi(String hi);
    }

    public static void main(String[] args) throws MalformedURLException {
        //TODO 根据实际地址修改
        String url = "http://localhost:8080/hello";
        HessianProxyFactory factory = new HessianProxyFactory();
        Hello basic = (Hello) factory.create(Hello.class, url);
        System.out.println(basic.hello(123));

        SumSay sumSay = (SumSay) factory.create(SumSay.class, url);
        System.out.println(sumSay.say("你好!"));

        System.out.println("10+20=" + sumSay.sum(10, 20));

        //System.out.println("10" + sumSay.sum(10));//报错
    }
    /*
    在客户端中我创建了两个接口，接口名和最上面Basic中的部分接口是一样的。

其中hello方法的参数类型和接口提供的不一致。

经过简单的测试发现，只要方法名一致，并且参数个数一致，就可以成功调用。

并且从上面的Hello和SumSay两个接口也可以看出来，不需要拥有原接口全部接口，可以只有部分接口（还可以多出来，但是不能调用）。

只有和Hessian接口一致的方法才能调用。
     */
}
