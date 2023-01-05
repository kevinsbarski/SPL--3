package assig3_1;

public class main {
    public static void main(String[] args){
        GamePlay game = new GamePlay();
        Gamer p1 = new Gamer(game,Thread.currentThread());
        Gamer p2 = new Gamer(game,Thread.currentThread());
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();
        assig3_1.Judge.JudgeGamePlay(game);
        if(p1.getScore() > p2.getScore())
            System.out.println("player 1 wins");
        else if(p1.getScore() < p2.getScore())
            System.out.println("player 2 wins");
        else
            System.out.println("tie");
    }
}
