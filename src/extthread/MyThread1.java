package extthread;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class MyThread1 extends Thread{
    public MyThread1(){
        System.out.println("构造方法的打印："+Thread.currentThread().getName());
    }
    public void run(){
        System.out.println("run方法运行的是："+Thread.currentThread().getName());
    }
    public static void main(String[] args){
        MyThread1 my = new MyThread1();
        my.start();
       // my.run();
    }
}
