package set.linkedhashset;

import java.util.LinkedHashSet;

/**
 * @Description: LinkedHashSet例子
 * @Author: daihong
 * @Date: Created in  2018/8/31
 */
public class LinkedHashSetTest {
    public static void main(String[] args){
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add("abc");
        lhs.add("efg");
        lhs.add("hij");
        System.out.println(lhs);
        lhs.remove(new String("efg"));
        lhs.add("efg");
        System.out.println(lhs);
    }
    /**
     * [abc, efg, hij]
     * [abc, hij, efg]
     * 显示结果是链表向前移动一步
     */
}
