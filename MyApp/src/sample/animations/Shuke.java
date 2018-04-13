package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shuke {
    private TranslateTransition tt;

    public Shuke(Node node){
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setFromY(0f);
        tt.setByX(10f);
        tt.setByY(23f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }

    public void playAnim(){
        tt.playFromStart();
    }
}
