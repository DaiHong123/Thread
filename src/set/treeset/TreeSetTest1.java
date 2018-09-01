package set.treeset;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description: 定制排序
 * @Author: daihong
 * @Date: Created in  2018/9/1
 */
public class TreeSetTest1 {
public static void main(String[] args){
    TreeSet ts = new TreeSet(new MyCommpare());
    ts.add(new M(5));
    ts.add(new M(3));
    ts.add(new M(9));
    System.out.println(ts);
}
}
class M{
    int age ;

    public M(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "M{" +
                "age=" + age +
                '}';
    }
}
class MyCommpare implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        M m1 = (M)o1;
        M m2 = (M)o2;
        return m1.age>m2.age?1:m1.age<m2.age?-1:0;
    }
}
