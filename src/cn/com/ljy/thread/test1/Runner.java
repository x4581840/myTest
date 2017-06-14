package cn.com.ljy.thread.test1;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wb-ljy189959 on 2017/6/14.
 */
public class Runner implements Callable<Integer>{

    private CountDownLatch begin;

    private CountDownLatch end;

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
