package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3Jun {
    // V2의 경우네는 while과 같은 부분에서 인터럽트를 체크하지 않으며 Thread.sleep 에서만 체크하는 아쉬움이 존재함
    // while 문에서 상태문을 체크한다면 더욱 빨라질 것임.

    public static void main(String[] args) {
        MyTask task = new MyTask();

        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 명령 thread.iterrupt()");
        thread.interrupt();
        log("work 쓰레드 인터럽트 상태 1 + = " + thread.isInterrupted());



    }

    static class MyTask implements Runnable {

        // volatile boolean runFlag = true;
        // volatile = 여러 스레드에서 공유하는 값에 사용되는 키워드

        @Override
        public void run() {
//            while(!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 확인 - 상태를바꾸지 않음
            while(!Thread.interrupted()){ //인터럽트 상태 확인 후 true false로 변경
                log("작업 중");
            }

            log("work 쓰레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted()); // 인터럽트 True 상태임

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) { // 해당 시점에 인터럽트를 정리하여 False 상태로 변경함 .
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("자원 정리");
            log("자원 종료");

        }
    }
}
