package currentThreadExt;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class CountOperate extends Thread {
    public void run(){
        System.out.println("run="+this.isAlive());
    }
    public static void main(String[] args){
        CountOperate countOperate = new CountOperate();
        System.out.println(countOperate.isAlive());
        countOperate.start();

        try {
            countOperate.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("123"+countOperate.isAlive());
    }
}
