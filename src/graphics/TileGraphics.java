package graphics;

import javafx.scene.image.Image;

public class TileGraphics extends CreatureGraphics {
            
//    Type, passable or collision, light, explore, items on it, small animals?, monster, other
//    physic module?
//    game mechanics
    
    public TileGraphics() {
        setImage(new Image(Graphics.ImgURL.Wall.getValue()));
    }
    
}
