package thread.start.test;


import static util.MyLogger.log;

public class StartTest4MainJun {
// 익명 클래스 요구
    public static void main(String[] args) {
        log("main Thread start");


        Thread cntCounterA = new Thread(new cntCounter("A", 1000), "counterA");
        Thread cntCounterB = new Thread(new cntCounter("B", 500), "counterB");

        cntCounterA.start();
        cntCounterB.start();

        log("main Thread end");
    }

    private static class cntCounter implements Runnable{
        private String name;
        private int sleepTime;

        public cntCounter(String name, int sleepTime){
            this.name = name;
            this.sleepTime =sleepTime;
        }

        @Override
        public void run() {
            while(true){
                log(name);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }




}
