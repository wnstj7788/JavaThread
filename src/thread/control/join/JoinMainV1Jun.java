package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV1Jun {

    public static void main(String[] args) {
        log("Start");

        // 해당 문제의 상황은 다음과 같음
        // 1부터 100까지 더하는 연산을 1 - 50 을 1번 쓰레드가
        // 51 - 100까지의 연산을 2번 쓰레드가 나눠서 작업을 수행할 것
        // runnable 생성
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        //thread 생성
        Thread thread1 = new Thread(sumTask1, "thread-1");
        Thread thread2 = new Thread(sumTask2, "thread-2");

        // thread 실행
        thread1.start();
        thread2.start();

        log("task1.result = " + sumTask1.result);
        log("task2.result = " + sumTask2.result);

        int resultSum = sumTask1.result + sumTask2.result;

        log("resultSum = " + resultSum);
        //15:12:47.076 [     main] resultSum = 0
        //왜 0이 나오는가 -> 2초를 기다리지만 Main Thread 명령 종료 후 조회해서 실행했기 때문임.

        //this를 명확하게 이해해야함
        // 스택 프레임을 만들 때 스택 프레임 내부에는 메서드의 이름만 존재하는 것이 아닌 내부에 this(호출한 메서드의 인스턴스)도 함께 생성됨.
        // 자바는 기본적으로 지역변수에서 변수를 찾고 로컬에 없다면 This를 포함하여 필드에서 찾게 된다.


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
