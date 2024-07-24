package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        // Main 메서드에서 실행되는 Main Thread
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        // start는 매우 특별한 메서드로 run메서드를 실행한다.
        helloThread.start(); // 지시만 하고 Main Thread는 기다리지 않음 왜? 실행은 thread-0이 담당하니까.
//        helloThread.run(); 절대 Run을 호출하면 안된다.
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");

        // 스레드 간 실행 순서 보장 안함.
        // 스레드는 동시에 실행되기 때문에 스레드 간 순서는 얼마든지 달라질 수 있음.


        /*
        Thread 실행 순서에 따라 다를 수 있음
        main: main() start
        main: start() 호출 전
        main: start() 호출 후 // 기다리지 않다다는 증거
        Thread-0: run()
        main: main() end

        main: main() start
        main: start() 호출 전
        main: start() 호출 후
        main: main() end
        Thread-0: run()
         */
    }
}
