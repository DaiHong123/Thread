package reentry;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
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
public class LocalConditionDemo1 {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public static void main(String[] args) throws Exception {
        LocalConditionDemo1 localConditionDemo = new LocalConditionDemo1();
        new Thread(()->localConditionDemo.await(localConditionDemo.conditionA),"thread1_conditionA").start();
        new Thread(()->localConditionDemo.await(localConditionDemo.conditionB),"thread2_conditionB").start();
        new Thread(()->localConditionDemo.signal(localConditionDemo.conditionA),"thread3_conditionA").start();
        Thread.sleep(5000);
        new Thread(()->localConditionDemo.signal(localConditionDemo.conditionB),"thread4_conditionB").start();
    }
    private void await(Condition condition) {
        try {
            lock.lock();
            System.out.println("开始等待await!ThreadName="+Thread.currentThread().getName());
            condition.await();
            System.out.println("等待结束!ThreadName="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    private void signal(Condition condition){
        lock.lock();
        System.out.println("开始发出通知！ThreadName="+Thread.currentThread().getName());
        condition.signal();
        lock.unlock();
    }
}
