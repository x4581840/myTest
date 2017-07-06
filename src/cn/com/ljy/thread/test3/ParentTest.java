package cn.com.ljy.thread.test3;

/**
 * Created by wb-ljy189959 on 2017/7/6.
 * Main线程结束，其他线程一样可以正常运行。
 * 主线程，只是个普通的非守护线程，用来启动应用程序，不能设置成守护线程；
 * 除此之外，它跟其他非守护线程没有什么不同。主线程执行结束，其他线程一样可以正常执行。
 */
public class ParentTest {
    public static void main(String[] args)
    {
        System.out.println("parent thread begin ");

        ChildThread t1 = new ChildThread("thread1");
        ChildThread t2 = new ChildThread("thread2");
        t1.start();
        t2.start();

        System.out.println("parent thread over ");
    }
}

class ChildThread extends Thread
{
    private String name = null;

    public ChildThread(String name)
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
 * parent thread begin
 parent thread over
 thread2--child thead begin
 thread1--child thead begin
 thread2--child thead over
 thread1--child thead over
 */
