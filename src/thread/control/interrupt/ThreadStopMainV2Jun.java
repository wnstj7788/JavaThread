package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2Jun {
    // 즉각 종료하고 싶다면 어떻게 해야할까?
    // 인터럽트를 사용하게 된다면 waltting, time_watting 상태를 직접 깨워서 Runnalbe 상태로 변경할 수 있다.

    public static void main(String[] args) {
        MyTask task = new MyTask();

        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 명령 thread.iterrupt()");
        thread.interrupt();
        log("work 쓰레드 인터럽트 상태 1 + = " + thread.isInterrupted());



    }

    static class MyTask implements Runnable {

        // volatile boolean runFlag = true;
        // volatile = 여러 스레드에서 공유하는 값에 사용되는 키워드

        @Override
        public void run() {
            try{
                while (true) {
                    log("작업 중");
                    Thread.sleep(3000); // 인터럽트가 걸리는 코드에서 InterruptedException으로 돌아간다
                }
            }catch (InterruptedException e) {
                log("work 쓰레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted()); // false가 된다 = RUNNABLE 된다.
                log("Interrupt massage = " + e.getMessage());
                log("status = " + Thread.currentThread().getState());
            }

            log("자원 정리");
            log("자원 종료");

        }
    }
}
