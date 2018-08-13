package Lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class ThreadLocalDemo extends Thread{
    public static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();
    public void setThreadLocal(List<String> value){
        threadLocal.set(value);
    }
    public void getThreadLocal(){
        System.out.println(Thread.currentThread().getName());
        threadLocal.get().forEach(name-> System.out.println(name));
    }
    public static void main(String[] args){
        final ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        new Thread(()->{
            List<String> params = new ArrayList<>(3);
            params.add("张三");
            params.add("李四");
            params.add("王五");
            threadLocalDemo.setThreadLocal(params);
            threadLocalDemo.getThreadLocal();
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
                List<String> params = new ArrayList<>(2);
                params.add("Chinese");
                params.add("English");
                threadLocalDemo.setThreadLocal(params);
                threadLocalDemo.getThreadLocal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
