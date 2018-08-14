package Lock;

import java.util.*;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class SimpleThreadLocal<T>{
    public  Map<Thread,T> valueMap = Collections.synchronizedMap(new HashMap<Thread,T>());
    public void set(T value){
        valueMap.put(Thread.currentThread(),value);
    }
    public T get(){
        Thread currentThread = Thread.currentThread();
        T t = valueMap.get(currentThread);
        if(t==null&&!valueMap.containsKey(currentThread)){
            t = initialValue();
        }
        return t;
    }
    public void remove(){
        valueMap.remove(Thread.currentThread());
    }
    private T initialValue() {
        return null;
    }
    public static void main(String[] args){
        SimpleThreadLocal<List<String>> threadLocal = new SimpleThreadLocal<>();

        new Thread(()->{
            List<String> params = new ArrayList<>();
            params.add("张三");
            params.add("李四");
            params.add("王五");
            threadLocal.set(params);
            System.out.println(Thread.currentThread().getName());
            threadLocal.get().forEach(param-> System.out.println(param));
        }).start();

        new Thread(()->{
            List<String> params = new ArrayList<>();
            params.add("Chinese");
            params.add("English");
            threadLocal.set(params);
            System.out.println(Thread.currentThread().getName());
            threadLocal.get().forEach(param-> System.out.println(param));
        }).start();
    }
}
