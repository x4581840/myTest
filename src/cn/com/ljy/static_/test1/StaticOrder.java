package cn.com.ljy.static_.test1;

/**
 * Created by wb-ljy189959 on 2017/5/22.
 */
public class StaticOrder {
    static {
        System.out.println("A");
    }

    static {
        System.out.println("B");
    }

    static {
        System.out.println("C");
    }

    public static void main(String[] args) {
        System.out.println("main");
    }

    static {
        System.out.println("D");
    }
    /**
     * 这里的顺序是A B C D mian
     */

    /**
     * static块可以置于类中的任何地方，类中可以有多个static块。在类初次被加载的时候，
     * 会按照static块的顺序来执行每个static块，并且只会执行一次
     */
}
