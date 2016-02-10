package graphics;

import javafx.scene.image.Image;

public class PlayerGraphics extends CreatureGraphics {

    public PlayerGraphics() {
        setImage(new Image(Graphics.ImgURL.Player.getValue()));
    }
    
}
