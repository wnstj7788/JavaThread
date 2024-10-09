package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {
    // Thred는 실행 순서를 보장하지 않기 때문에, 실행 결과는 약간 다를 수 있다.
    /*
    13:18:58.227 [     main] Start
    13:18:58.230 [ thread-1] 작업 시작
    13:18:58.230 [     main] End
    13:18:58.230 [ thread-2] 작업 시작
    13:19:00.231 [ thread-2] 작업 완료
    13:19:00.231 [ thread-1] 작업 완료
     */

    public static void main(String[] args) {
        log("Start");
        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");

        thread1.start();
        thread2.start();
        log("End");

        // 만약 thread 1, thread2 의 반환 값을 이용하고 Main Thread에서 연산이 필요하다면 어떻게 해야할까?

    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        }
    }
}
