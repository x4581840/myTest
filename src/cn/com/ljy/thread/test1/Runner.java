package cn.com.ljy.thread.test1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by wb-ljy189959 on 2017/6/14.
 */
public class Runner implements Callable<Integer>{
    //开始信号
    private CountDownLatch begin;
    //结束信号
    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        //super();
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        //跑步的成绩
        int score = new Random().nextInt(25);
        //等待发令枪响起
        begin.await();
        //跑步中
        TimeUnit.MILLISECONDS.sleep(score);
        //跑步者已经跑完全程
        end.countDown();
        return score;
    }
}
