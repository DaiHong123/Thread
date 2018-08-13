package Lock;

import java.util.concurrent.*;

/**
 * @Author: daihong
 * @Date: $date$
 */
public class ThreadPoolDemo {
    public static void main(String[] args){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,2,0L,TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for(int i=0;i<10;i++){
            int index = i;
            poolExecutor.submit(()-> System.out.println("i:"+index+"executorService"));
        }
        poolExecutor.shutdown();
    }
}
