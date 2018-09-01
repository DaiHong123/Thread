package set.treeset;

import java.util.TreeSet;

/**
 * @Description: TreeSet例子
 * @Author: daihong
 * @Date: Created in  2018/8/31
 */
public class TreeSetTest {
    public static void main(String[] args){
        TreeSet ts = new TreeSet();
        /*ts.add(new Err());
        ts.add(new Err());*/
        ts.add(new Errs());
        System.out.println(ts);
    }
}
class Err {

}
class Errs implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
/**
 * Exception in thread "main" java.lang.ClassCastException: set.treeset.Err cannot be cast to java.lang.Comparable
 *结果显示如果TreeSet中的元素没有实现Comparable接口就会出错.
 */
