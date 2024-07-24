package thread.start;

public class DaemonThreadMain {
    /*
    스레드는 데몬 스레드와 사용자 스레드 2종류로 구분이 가능함
    사용자 스레드  non thread
    = 프로그램의 주요 작업을 수행함
    작업이 완료될 때까지 실행함
    모든 User 스레드가 종료되면 jvm도 종료된다.

    데몬 스레드
    백그라운드에서 보조적인 역할을 수행함
    모든 user 스레드가 종료되면 데몬 스레드는 자동으로 종료된다.

    jvm은 데몬 스레드의 실행 완료를 기다리지 않고 종료됨
     데몬 스레드가 아닌 모든 스레드가 종료되면 가바 프로그램은 종료된다.
     */

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // 데몬 스레드를 명시적으로 표기함
        //  daemonThread.setDaemon(false); // 기다림 - 유저 쓰레드로 만들기 때문
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    /*
    - 데몬 스레드이기 떄문에 대기하기 않고 바로 종료 된다.
    main: main() start
    main: main() end
    Thread-0: run()
     */

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
