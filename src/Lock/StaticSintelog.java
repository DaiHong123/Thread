package Lock;

/**
 * @Author: daihong
 * @Date: $date$
 */
public class StaticSintelog {
    private static class SingletonHolder{
        private static final StaticSintelog instance = new StaticSintelog();
    }
    private StaticSintelog(){}
    public static final StaticSintelog getInstance(){
        return SingletonHolder.instance;
    }
}
