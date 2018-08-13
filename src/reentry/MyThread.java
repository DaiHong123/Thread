package reentry;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class MyThread {
    public synchronized void method1(){
        System.out.println("method1------");
        method2();
    }
    public synchronized void method2(){
        System.out.println("method2------");
        method3();
    }
    public synchronized void method3(){
        System.out.println("method3------");
    }
    public static void main(String[] args){
        final MyThread myThread = new MyThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.method1();
            }
        }).start();
    }
}
