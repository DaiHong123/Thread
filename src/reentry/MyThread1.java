package reentry;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class MyThread1 extends Thread {
    private int i = 0;
    public synchronized void run(){
        while (true){
            i++;
            System.out.println(Thread.currentThread().getName()+",i="+i);
            if(i==10){
                Integer.parseInt("a");
            }
        }
    }
    public static void main(String[] args){
      final MyThread1 myThread1 = new MyThread1();
      Thread thread = new Thread(myThread1,"a");
      thread.start();
    }
}
