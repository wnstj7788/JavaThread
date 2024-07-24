package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        // main 스레드
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId()=" + mainThread.threadId());
        log("mainThread.getName()=" + mainThread.getName());
        log("mainThread.getPriority()=" + mainThread.getPriority()); // 기본이 5이며 높을 수록 우선순위가 있음
        log("mainThread.getThreadGroup()=" + mainThread.getThreadGroup());
        log("mainThread.getState()=" + mainThread.getState());

        // myThread 스레드
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId()=" + myThread.threadId()); // 스레드 고유 식별자로 임의로 결정할 수 없으며 JVM에 의해 자동으로 결정된다.
        log("myThread.getName()=" + myThread.getName()); // 중복 가능
        log("myThread.getPriority()=" + myThread.getPriority()); //1이 가장 낮으며 10이 가장 높음 - 5가 디폴트임
        // 운영체제와 시간에 따라 다르다.
        log("myThread.getThreadGroup()=" + myThread.getThreadGroup()); // 부모 스레드와 동일 스레드 그룹에 속함
        // 그룹화 할 수 있는 기능을 제공함
        // 부모 스레드 : 새로운 스레드를 생성하는 스레드를 의미함. myThread의 경우 Main Thread에 의해 실행되기 때문에 부모 스레드는 Main Thread임
        log("myThread.getState()=" + myThread.getState()); //생성되고 실행하지 않으면 New

//     **NEW**: 스레드가 아직 시작되지 않은 상태이다.
//     **RUNNABLE**: 스레드가 실행 중이거나 실행될 준비가 된 상태이다.
//     **BLOCKED**: 스레드가 동기화 락을 기다리는 상태이다.
//     **WAITING**: 스레드가 다른 스레드의 특정 작업이 완료되기를 기다리는 상태이다.
//     **TIMED_WAITING**: 일정 시간 동안 기다리는 상태이다.
//     **TERMINATED**: 스레드가 실행을 마친 상태이다.

    }
}
