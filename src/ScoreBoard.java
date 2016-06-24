import ball.Balls;

import java.util.Observable;

public class ScoreBoard extends Observable {

    public ScoreBoard() {
    }

    private void notify(Balls balls) {
        for (int i = 0; i < balls.total(); i++) {
            setChanged();
            notifyObservers(balls.get(i));
        }
    }

    public void update(Balls balls) {
        this.notify(balls);
    }
}
