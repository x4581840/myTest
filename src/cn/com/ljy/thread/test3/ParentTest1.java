package cn.com.ljy.thread.test3;

/**
 * Created by wb-ljy189959 on 2017/7/6.
 * Main线程结束，其他线程也可以立刻结束，当且仅当这些子线程都是守护线程。
 * java虚拟机(相当于进程)退出的时机是：虚拟机中所有存活的线程都是守护线程。
 * 只要还有存活的非守护线程虚拟机就不会退出，而是等待非守护线程执行完毕；
 * 反之，如果虚拟机中的线程都是守护线程，那么不管这些线程的死活java虚拟机都会退出
 */
public class ParentTest1 {
    public static void main(String[] args)
    {
        System.out.println("parent thread begin ");

        ChildThread1 t1 = new ChildThread1("thread1");
        ChildThread1 t2 = new ChildThread1("thread2");
        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        System.out.println("parent thread over ");
    }
}
class ChildThread1 extends Thread {
    private String name = null;
    public ChildThread1(String name)
    {
        this.name = name;
    }
    @Override
    public void run()
    {
        System.out.println(this.name + "--child thead begin");
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
        System.out.println(this.name + "--child thead over");
    }
}
/**
 * 执行结果如下：
 parent thread begin
 parent thread over
 thread1--child thead begin
 或者是
 parent thread begin
 parent thread over
 或者是
 parent thread begin
 parent thread over
 thread1--child thead begin
 thread2--child thead begin
 有问题啊，上面出现的两种结果并不能说明主线程结束后，子线程里面结束了，返回还在执行
 */
