package stop.t12;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class MyThread extends Thread {
    public MyThread(){
        System.out.println(Thread.currentThread().getName());
    }
    public void run(){
        for(int i=0; i<5000; i++){
            System.out.println("i="+(i+1)+":"+Thread.currentThread().getName());
        }
    }
}
