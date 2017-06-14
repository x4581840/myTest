package cn.com.ljy.thread.test1;

/**
 * Created by wb-ljy189959 on 2017/5/19.
 */
public class JoinTest1 {
    public static void main(String[] args) throws InterruptedException {
        //MyThread mt = new MyThread();
        Thread mt = new Thread(new MyThread());
        mt.start();
        //使一个线程等待另外一个线程执行完成后执行
        //这里是main线程等待mt线程执行完毕后执行，相当于睡眠了mt线程一样的时间
        mt.join();
        System.out.println("MyThread线程执行完成");
    }
    //join的底层实现是使用了wait进行等待（释放了锁）
    //而synchronized使用的是对象监视器原理作为同步
}
