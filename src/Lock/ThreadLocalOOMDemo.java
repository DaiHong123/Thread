package Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class ThreadLocalOOMDemo {
    private static final int THREAD_LOOP_SIZE = 500;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 10000;
    private static ThreadLocal<List<User>> threadLocal = new ThreadLocal<>();
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);
        for(int i=0;i<THREAD_LOOP_SIZE;i++){
            executorService.execute(()->{
                threadLocal.set(new ThreadLocalOOMDemo().addBigList());
                Thread t = Thread.currentThread();
                System.out.println(Thread.currentThread().getName());
                //threadLocal.remove();
            });
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // executorService.shutdown();
    }
    private List<User> addBigList(){
        List<User> params = new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
        for (int i=0;i<MOCK_DIB_DATA_LOOP_SIZE;i++){
            params.add(new User("daiHong","password"+i,"男",i));
        }
        return params;
    }
}
class User{
    private String userName;
    private String password;
    private String sex;
    private int age;

    public User(String userName, String password, String sex, int age) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }
}

