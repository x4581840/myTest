package cn.com.ljy.static_.test1;

/**
 * Created by wb-ljy189959 on 2017/5/22.
 */
public class Main {
    static int value = 33;

    public static void main(String[] args) throws Exception{
        new Main().printValue();
    }

    private void printValue(){
        int value = 3;
        //System.out.println(this.value);//33
        //System.out.println(value);//3
        System.out.println(Main.value);//33
    }
    /**
     * static是不允许用来修饰局部变量
     */
}
