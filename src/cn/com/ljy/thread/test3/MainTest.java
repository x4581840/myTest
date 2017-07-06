package cn.com.ljy.thread.test3;

/**
 * Created by wb-ljy189959 on 2017/7/6.
 * Main线程是个非守护线程，不能设置成守护线程。
 *  这是因为，main线程是由java虚拟机在启动的时候创建的。
 *  main方法开始执行的时候，主线程已经创建好并在运行了。
 *  对于运行中的线程，调用Thread.setDaemon()会抛出异常Exception in thread "main"
 *  java.lang.IllegalThreadStateException
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println(" parent thread begin ");
        Thread.currentThread().setDaemon(true);
    }
}
