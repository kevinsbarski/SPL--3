package assig3_1;

import assig3_1.GamePlay;

public class Judge {

    public static void JudgeGamePlay(GamePlay gamePlay) {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000);
                gamePlay.makeCoinAvail(true);
                Thread.sleep(500);
                gamePlay.makeCoinAvail(false);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
}

