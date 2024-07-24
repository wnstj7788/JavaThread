package thread.control;

import util.ThreadUtils;

import static util.ThreadUtils.*;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() /*throws Exception*/ { // 주석 풀면 예외 발생
            //throw new Exception(); // 주석 풀면 예외 발생
            sleep(1000); // 예외를 생성해서 직접 던질 수 도 있음
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
              //  멀티 스레딩 환경에서는 에외 처리를 강제함으로 스레드의 안전성과 일관성을 유지할 수 있음.
            }
        }

        /*
        자바 메서드를 재정의할 때, 재정의 메서드가 지켜야할 에외와 관련 규칙이 존재함
        1. 체크 예외
            부모 메서드가 체크 예외를 던지지 않는 경우, 재정의된 자식 메서드도 체크 예외를 던질 수 없음
            자식 메서드는 부모 메서드가 던질 수 있는 체크 에외의 하위 타입만 던질 수 있다.

            public interface Runnable {
              void run();
              }
        2. 언체크(런타임) 예외
            예외 처리를 강제하지 않으므로 상관 없이 던질 수 있다.


        이유 : 자식 클래스가 더 넓은 예외를 던지면 해당 코드를 모든 예외를 제대로 처리할 수 없음
        일관성을 해치고 예상치 못 한 런타임 오류를 초래할 수 있음.

        최근에는 런타임 에러를 많이 발생 시켜 해결한다.


         */
    }
}
