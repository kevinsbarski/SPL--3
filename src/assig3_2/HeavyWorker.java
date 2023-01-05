package assig3_2;

import java.sql.Timestamp;
import java.util.Date;
public class HeavyWorker {
    private MySemaphore section1Semaphore = new MySemaphore(3);  // up to 3 threads can enter section1 at the same time
    private MySemaphore section2Semaphore = new MySemaphore(1);  // only 1 thread can enter section2 at the same time

    public void section1() {
        section1Semaphore.down();
        System.out.println(Thread.currentThread().getName() + " is in section1");
        try {

            Thread.sleep(500);
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " leaving section1");
        section1Semaphore.up();
    }

    public void section2() {
        section2Semaphore.down();
        System.out.println(Thread.currentThread().getName() + " is in section2");
        try {
            /* sleep to simulate some work... */
            Thread.sleep(500);
        } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " leaving section2");
        section2Semaphore.up();
    }

    public void workA() {
        System.out.println(Thread.currentThread().getName() + " doing workA");

        section1();

        section2();
    }

    public void workB() {

        System.out.println(Thread.currentThread().getName() + " doing workB");
    }
}
