package Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockDemo();
        /*new Thread(() -> reentrantReadWriteLockDemo.read(), "thread1").start();
        new Thread(()->reentrantReadWriteLockDemo.read(),"thread2").start();*/
        new Thread(() -> reentrantReadWriteLockDemo.read(), "thread1").start();
        Thread.sleep(2000);
        new Thread(()->reentrantReadWriteLockDemo.write(),"thread2").start();
    }

    private void read() {
        try {
            try {
                reentrantReadWriteLock.readLock().lock();
                System.out.println("获得读锁：" + Thread.currentThread().getName() + "时间：" + System.currentTimeMillis());
                Thread.sleep(5000);
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void write() {
        try {
            try {
                reentrantReadWriteLock.writeLock().lock();
                System.out.println("获得读锁：" + Thread.currentThread().getName() + "时间：" + System.currentTimeMillis());
                Thread.sleep(5000);
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
