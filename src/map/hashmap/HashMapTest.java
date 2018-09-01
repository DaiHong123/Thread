package map.hashmap;

import java.util.Collections;
import java.util.HashMap;

/**
 * @Description: 让HashMap同步
 * @Author: daihong
 * @Date: Created in  2018/9/1
 */
public class HashMapTest {
    public static void main(String[] args){
        HashMap hashMap = new HashMap();
        hashMap.put(1,2);
        hashMap.put(2,3);
        Collections.synchronizedMap(hashMap);
    }
}
