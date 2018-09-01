package set.enumset;

import java.util.EnumSet;

/**
 * @Description: EnumSet特征：自动排序，排序规则是按Enum类中元素定义的顺序
 * @Author: daihong
 * @Date: Created in  2018/9/1
 */
public class EnumSetTest {
    public static void main(String[] args) {
        /**
         * 枚举类型的所有
         */
        EnumSet es = EnumSet.allOf(Season.class);
        System.out.println(es);
        /**
         * 添加的
         */
        EnumSet es2 = EnumSet.noneOf(Season.class);
        es2.add(Season.WINTER);
        es2.add(Season.SUMMER);
        System.out.println(es2);
        /**
         * 添加的
         */
        EnumSet es3 = EnumSet.of(Season.WINTER,Season.SUMMER);
        System.out.println(es3);
        /**
         * 从summer到winter
         */
        EnumSet es4 = EnumSet.range(Season.SUMMER,Season.WINTER);
        System.out.println(es4);
        /**
         * 除了es4之外的
         */
        EnumSet es5 = EnumSet.complementOf(es4);
        System.out.println(es5);
    }
}

enum Season {
    SPRING, SUMMER, FALL, WINTER;
}

/**
 * 执行结果：
 * [SPRING, SUMMER, FALL, WINTER]
 * [SUMMER, WINTER]
 * [SUMMER, WINTER]
 * [SUMMER, FALL, WINTER]
 * [SPRING]
 */