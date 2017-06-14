package cn.com.ljy.hessian.test1;

import com.caucho.hessian.server.HessianServlet;

/**
 * Created by wb-ljy189959 on 2017/5/18.
 */
public class BasicService extends HessianServlet implements Basic {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String say(String msg) {
        return "Say:" + msg;
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
