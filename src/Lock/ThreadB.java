package Lock;

import reentry.MyList;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class ThreadB extends Thread{
    private Object lock;
    public ThreadB(Object lock){
        this.lock = lock;
    }
    public void run(){
        try {
            synchronized(lock){
                for(int i=0;i<10;i++){
                    MyList.add();
                    if(MyList.size()==5){
                        lock.notify();
                        System.out.println(Thread.currentThread().getName()+"已发出通知");
                    }
                    System.out.println(Thread.currentThread().getName()+"添加了："+(i+1)+"个元素！");
                    Thread.sleep(1000);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
