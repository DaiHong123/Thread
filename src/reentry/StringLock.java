package reentry;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class StringLock extends Thread {
    public String lock = "lock";
    public void run(){
        synchronized(lock){
            try{
                System.out.println("当前线程："+Thread.currentThread().getName()+"开始");
                Thread.sleep(1000);
                System.out.println("当前线程："+Thread.currentThread().getName()+"结束");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        final StringLock stringLock = new StringLock();
        Thread thread = new Thread(stringLock,"A");
        Thread thread1 = new Thread(stringLock,"B");
        thread.start();
        thread1.start();
    }
}
