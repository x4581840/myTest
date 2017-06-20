package cn.com.ljy.thread.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wb-ljy189959 on 2017/6/14.
 * CountDownLatch是一个同步工具类，
 * 它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws Exception{
        //参加赛跑人数
        int people = 10;
        //发令枪只响一次
        CountDownLatch begin = new CountDownLatch(1);
        //参加跑步的人数
        CountDownLatch end = new CountDownLatch(people);
        //每个跑步者一个跑道
        ExecutorService es = Executors.newFixedThreadPool(people);
        //记录比赛成绩
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        //跑步者就位，所有线程出于等待状态
        for(int i=0;i<people;i++) {
            futures.add(es.submit(new Runner(begin, end)));
        }
        //发令枪响，跑步者开始跑步
        begin.countDown();
        //等待所有跑步者跑完全程
        end.await();
        //统计总分
        int count = 0;
        for(Future<Integer> future : futures) {
            count += future.get();
        }
        System.out.println("平均分数"+count/people);
    }
}
