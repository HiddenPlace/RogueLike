package mechanics;

public class Map {
    
//    Changes in map
    
    private TileMap[][] map;

    public Map() {
        map = new TileMap[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = new TileMap();
            }
        }
    }
    
    public TileMap[][] getMap() {
        return map;
    }
    
}
