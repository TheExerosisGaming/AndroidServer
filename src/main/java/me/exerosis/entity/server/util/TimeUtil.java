package me.exerosis.entity.server.util;

/**
 * Created by The Exerosis on 8/9/2015.
 */
public class TimeUtil {
    private TimeUtil() {}

    public static void runTaskLater(long mills, Runnable runnable){
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(mills);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runnable.run();
            }
        }.start();
    }
}
