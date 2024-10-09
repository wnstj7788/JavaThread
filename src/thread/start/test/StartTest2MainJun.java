package thread.start.test;


import static util.MyLogger.log;

public class StartTest2MainJun {

    public static void main(String[] args) {
        log("main Thread start");

        Thread thread = new Thread(new CounterRunnable(), "counter");
        thread.start();
        log("main Thread end");
    }

     private static class CounterRunnable implements Runnable {
         public void run() {
             for (int i = 1; i <= 5 ; i++) {
                 log("value " + i);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
         }
     }

}
