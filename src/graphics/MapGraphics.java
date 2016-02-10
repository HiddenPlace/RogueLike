package graphics;

import javafx.scene.image.ImageView;
import mechanics.Map;

public class MapGraphics {
    private ImageView[][] mapGraphics;
//    CONST!!!
    private int mapSize = 20;
    private Map map;

    public MapGraphics() {
        mapGraphics = new ImageView[mapSize][mapSize];
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public ImageView[][] getMap() {
        return mapGraphics;
    }
    
    public void updateMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
//                map[i][j] = mapR.getMap()[i][j].getTypeId();
            }
        }
    }
    
    public void setMapSize(int size) {
        mapSize = size;
    }
}
