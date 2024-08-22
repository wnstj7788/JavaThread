package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV3Jun {
    // 특정 쓰레드를 기다리게 하는 가자아 간단한 방법은 Sleep()을 사용하는 것 임.

    public static void main(String[] args) throws InterruptedException {
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

//        log("main thread sleep()");
//
//        sleep(2500); // Thread!! sleep
//
//        log("main thread wakeUp()");

        // Main Thread가 Join이 붙은 스레드를 기다렸다 실행함
        //Waiting 대기 상태
        // 스레드가 다른 스레드의 특정 작업이 완료도기를 무기한 기다리를 상태
        // Join()을 호출하는 스레드는 대상 스레드가 Terminated 상태가 될 때 까지 대기함.
        // 대상 스레드의 상태가 Terminated 상태가 되면 호출 스레드는 다시 Runnable상태로 돌아옴
        // 해당 방식 또한 무기한 대기를 해야하는 단점이 존재함. 만약, 일정 시간만을 기다리고 싶다면 적합하지 않음.
        log("join - main 스레드가 thread1, thread2 종료까지 대기");
        thread1.join(); //main thread waiting 상태로 대기
        thread2.join();
        log("join - main 스레드가 thread1, thread2 종료까지 대기 완료 ");

        log("task1.result = " + sumTask1.result);
        log("task2.result = " + sumTask2.result);

        int resultSum = sumTask1.result + sumTask2.result;

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
            //sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;

            log("작업 완료 result " + result);

        }
    }
}
