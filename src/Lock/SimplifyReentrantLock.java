package Lock;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class SimplifyReentrantLock implements Lock {
    private final Sync sync = new Sync();
    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
        Condition newCondition(){
            return new ConditionObject();
        }
    }
    @Override
    public void lock() {
sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
class SimplifyReentrantLockDemo{
    public static void main(String[] args){
        SimplifyReentrantLock lock = new SimplifyReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("进入等待！"+Thread.currentThread().getName());
                condition.await();
                System.out.println("接到通知！继续执行！");
            }catch (Exception e){
                e.printStackTrace();
            }
            lock.unlock();
        },"conditionAwaitThread").start();
        new Thread(()->{
            try{
                System.out.println("模拟3秒后发送通知过！");
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("发送通知");
            condition.signal();
            lock.unlock();
        },"conditionSignalThread").start();
    }
}