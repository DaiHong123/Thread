package Lock;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class SummonDragonDemo {
    private static final int THREAD_COUNT_NUM = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("寻找龙珠");
                summonDragon();
            }
        });
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("收集了：" + index + "龙珠");
                    Thread.sleep(1000);
                    /**
                     * 等待
                     */
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("集齐龙珠了");
    }

    private static void summonDragon() {
        CyclicBarrier summonDragonBarrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("找到了");
            }
        });
        for(int i=1;i<=THREAD_COUNT_NUM;i++){
            int index = i;
            new Thread(()->{
                try {
                    System.out.println("第"+index+"龙珠收集成功");
                    summonDragonBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
