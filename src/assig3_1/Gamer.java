package assig3_1;

public class Gamer implements Runnable{

    private int goodFlipsCounter;
    private GamePlay gamePlay;
    private Thread judge;

    public Gamer(GamePlay gamePlay, Thread main) {
        this.gamePlay = gamePlay;
        this.goodFlipsCounter = 0;
        this.judge = main;
    }

    public void play() throws InterruptedException {
        while(!Thread.currentThread().isInterrupted() && gamePlay.getNumOfRounds() <= 10){
            int result = gamePlay.flipCoin();
            if (result == 1) {
                goodFlipsCounter++;
            } else if (result == 0) {
                goodFlipsCounter--;
            }
            Thread.sleep(1000);
        }
        if(gamePlay.getNumOfRounds() >= 10) {
            judge.interrupt();
        }
    }

    public int getScore() {
        return goodFlipsCounter;
    }

    @Override
    public void run() {
        try {
            this.play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
