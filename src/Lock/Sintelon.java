package Lock;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Sintelon {
    private static Sintelon instance ;
    public static String VARIABLE = "hello world";
    private Sintelon(){
        System.out.println("123");
    }
    public static synchronized Sintelon getInstance(){
        if(instance==null){
            instance = new Sintelon();
        }
        return instance;
    }
    public static void main(String[] args){
        for(int i=0;i<3;i++){
            System.out.println(Sintelon.VARIABLE);
        }
    }
}
