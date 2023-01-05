package assig3_1;

import java.util.Random;

public class GamePlay {
    private boolean coinAvailable;
    private int roundsCounter;
    private Object lock;

    public GamePlay() {
        this.coinAvailable = false;
        this.roundsCounter = 0;
        this.lock = new Object();
    }

    public void makeCoinAvail(boolean val) {
        synchronized (lock) {
            coinAvailable = val;
            lock.notifyAll();
        }
    }

    public int flipCoin() {
        synchronized (lock) {
            while (!coinAvailable) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting for coin");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (roundsCounter >= 20) {
                return -1;
            }
            coinAvailable = false;
            System.out.println(Thread.currentThread().getName() + " is flipping coin");
            int result = new Random().nextInt(2);
            if (result == 1) {
                roundsCounter++;
            }
            return result;
        }
    }
    public int getNumOfRounds() {
        return roundsCounter;
    }
}
