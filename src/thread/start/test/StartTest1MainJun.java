package thread.start.test;


import static util.MyLogger.log;

public class StartTest1MainJun {

    public static void main(String[] args) {
        log("main Thread start");
        CounterThread  countThread = new CounterThread();
        countThread.start();
        log("main Thread end");
    }

     private static class CounterThread extends Thread {

        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                log("value " + (i +1 ));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }

}
