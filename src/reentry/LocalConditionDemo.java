package reentry;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class LocalConditionDemo {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public static void main(String[] args) throws Exception {
        LocalConditionDemo localConditionDemo = new LocalConditionDemo();
        new Thread(()->localConditionDemo.await(),"thread1").start();
        new Thread(()->localConditionDemo.await(),"thread2").start();
        new Thread(()->localConditionDemo.signal(),"thread3").start();
        Thread.sleep(1000);
        new Thread(()->localConditionDemo.signal(),"thread4").start();
    }

    private void await() {
        try {
            lock.lock();
            System.out.println("开始等待await！ThreadName="+Thread.currentThread().getName());
            condition.await();
            System.out.println("等待结束！ThreadName="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    private void signal(){
        lock.lock();
        System.out.println("开始发出通知！ThreadName="+Thread.currentThread().getName());
        condition.signal();
        lock.unlock();
    }
}
