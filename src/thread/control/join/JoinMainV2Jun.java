package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV2Jun {
    // 특정 쓰레드를 기다리게 하는 가자아 간단한 방법은 Sleep()을 사용하는 것 임.

    public static void main(String[] args) {
        log("Start");
        // runnable 생성
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        //thread 생성
        Thread thread1 = new Thread(sumTask1, "thread-1");
        Thread thread2 = new Thread(sumTask2, "thread-2");

        // thread 실행
        thread1.start();
        thread2.start();

        log("main thread sleep()");

        sleep(2500); // Thread!! sleep

        log("main thread wakeUp()");

        log("task1.result = " + sumTask1.result);
        log("task2.result = " + sumTask2.result);

        int resultSum = sumTask1.result + sumTask2.result;

        log("resultSum = " + resultSum);
        //16:18:43.532 [     main] resultSum = 5050
        // 참고하는 타이밍에 계산이 완료 되었다면 0이 아닌 우리가 원하는 5050이 나오게 된다
        // 현재 방법은 2초가 걸릴 것을 알고 있기 대문에 유용한 방식이다
        // 언제 Thread가 종료될지 모르는 상황에서는 적절하지 않다.
        // Join 메서드를 이용하면 이를 해결 할 수 있다.




        log("end");
    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result = 0;
        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;

            log("작업 완료 result " + result);

        }
    }
}
