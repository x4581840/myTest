package cn.com.ljy.thread.test1;

/**
 * Created by wb-ljy189959 on 2017/5/19.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            int sleepTime = (int)(Math.random()*10000);
            System.out.println(sleepTime);
            Thread.sleep(sleepTime);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
