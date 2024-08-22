package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4Jun {
    // 특정 쓰레드를 기다리게 하는 가자아 간단한 방법은 Sleep()을 사용하는 것 임.

    public static void main(String[] args) throws InterruptedException {
        log("Start");
        // runnable 생성
        SumTask sumTask1 = new SumTask(1, 50);
//        SumTask sumTask2 = new SumTask(51, 100);

        //thread 생성
        Thread thread1 = new Thread(sumTask1, "thread-1");
//        Thread thread2 = new Thread(sumTask2, "thread-2");

        // thread 실행
        thread1.start();
//        thread2.start();

        log("join - main 스레드가 thread1, thread2 종료까지 대기");
        thread1.join(1000); //최대 1초까지만 대기 해당 상태는 Waiting이 아닌 Time_Waiting이 된다
//        thread2.join();
        log("join - main 스레드가 thread1, thread2 종료까지 대기 완료 ");

        log("task1.result = " + sumTask1.result);
//        log("task2.result = " + sumTask2.result);

        int resultSum = sumTask1.result; // + sumTask2.result;

        log("resultSum = " + resultSum);


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
