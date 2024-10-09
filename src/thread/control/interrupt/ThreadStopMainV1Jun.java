package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1Jun {
    // 스레드를 중지 시키고 싶을 때 어떻게 해야할까?

    public static void main(String[] args) {
        MyTask task = new MyTask();

        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 명령 runFlag == false");
        task.runFlag = false;

        // 해당 방식의 문제점은 바로 적용되지 않는 다는 점이다
        // 예를 들어 task가 sleep 중이라면 sleep 종료 후 flag 값을 확인하는 시점이 되어야 종료된다는 점이다


    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;
        // volatile = 여러 스레드에서 공유하는 값에 사용되는 키워드

        @Override
        public void run() {
            while (runFlag) {
                log("작업 중");
                sleep(3000);
            }
            log("자원 정리");
            log("자원 종료");

        }
    }
}
