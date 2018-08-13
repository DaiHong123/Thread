package stop;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class MyThread extends Thread {
    public void run(){
        for(int i=0; i<50000; i++){
            System.out.println("i="+(i+1));
        }
    }
    public static void main(String[] args){
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

    }

}
