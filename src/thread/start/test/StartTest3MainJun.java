package thread.start.test;


import static util.MyLogger.log;

public class StartTest3MainJun {
// 익명 클래스 요구
    public static void main(String[] args) {
        log("main Thread start");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=5 ; i++) {
                    log("value " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread counterThread = new Thread(runnable, "counter");
        counterThread.start();

        log("main Thread end");
    }



}
