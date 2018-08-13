package reentry;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class MyList {
    private static List list = new ArrayList();
    public static void add(){
        list.add("我是元素");
    }
    public static int size(){
        return list.size();
    }
}
