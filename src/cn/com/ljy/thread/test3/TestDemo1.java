package cn.com.ljy.thread.test3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wb-ljy189959 on 2017/7/6.
 */
class TestRunnable implements Runnable{

    @Override
    public void run(){
        try{
            Thread.sleep(1000);//守护线程阻塞1秒后运行
            File f=new File("D:\\myTest\\myTest\\src\\cn\\com\\ljy\\thread\\test3\\demo.txt");
            FileOutputStream os=new FileOutputStream(f,true);
            os.write("daemon".getBytes());
        }
        catch(IOException e1){
            e1.printStackTrace();
        } catch(InterruptedException e2){
            e2.printStackTrace();
        }
    }
}

public class TestDemo1{
    public static void main(String[] args) throws InterruptedException {
        Runnable tr=new TestRunnable();
        Thread thread=new Thread(tr);
        thread.setDaemon(true); //设置守护线程,注释掉的是可以写入文件的
        thread.start(); //开始执行分进程
    }
}

/**
 最近重新研究Java基础知识，发现以前太多知识知识略略带过了，比较说Java的线程机制，在Java中有两类线程：User Thread(用户线程)、Daemon Thread(守护线程) ，（PS:以前忽略了）。

 估计学过Unix开发但是没有细致学习Java的同学们会疑惑了，操作系统里面是没有所谓的守护线程的概念，只有守护进程一说，但是Java语言机制是构建在JVM的基础之上的，意思是Java平台把操作系统的底层给屏蔽起来，所以它可以在它自己的虚拟的平台里面构造出对自己有利的机制，而语言或者说平台的设计者多多少少是收到Unix思想的影响，而守护线程机制又是对JVM这样的平台凑合，于是守护线程应运而生。

 Daemon的作用是为其他线程的运行提供服务，比如说GC线程。其实User Thread线程和Daemon Thread守护线程本质上来说去没啥区别的，唯一的区别之处就在虚拟机的离开：如果User Thread全部撤离，那么Daemon Thread也就没啥线程好服务的了，所以虚拟机也就退出了。

 守护线程并非虚拟机内部可以提供，用户也可以自行的设定守护线程，方法：public final void setDaemon(boolean on) ；但是有几点需要注意：

 1）、thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。  （备注：这点与守护进程有着明显的区别，守护进程是创建后，让进程摆脱原会话的控制+让进程摆脱原进程组的控制+让进程摆脱原控制终端的控制；所以说寄托于虚拟机的语言机制跟系统级语言有着本质上面的区别）

 2）、 在Daemon线程中产生的新线程也是Daemon的。  （这一点又是有着本质的区别了：守护进程fork()出来的子进程不再是守护进程，尽管它把父进程的进程相关信息复制过去了，但是子进程的进程的父进程不是init进程，所谓的守护进程本质上说就是“父进程挂掉，init收养，然后文件0,1,2都是/dev/null，当前目录到/”）

 3）、不是所有的应用都可以分配给Daemon线程来进行服务，比如读写操作或者计算逻辑。因为在Daemon Thread还没来的及进行操作时，虚拟机可能已经退出了。
 */