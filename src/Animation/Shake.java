package Animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

// Setting Animation
    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(-7f);
        tt.setByX(7f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public void playAnim(){
        tt.playFromStart();
    }
}
