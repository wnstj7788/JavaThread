package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        log("main() start");

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }

    // 여기서만 사용할 것 같다면 중첩 클래스를 활용하여 구현하면 된다.
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }

}
