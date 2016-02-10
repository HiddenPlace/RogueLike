package mechanics;

public interface Tile {
    
    enum tileType {
        Ground(0),
        Wall(1);
        
        private final int typeId;
        
        tileType(int typeId) {
            this.typeId = typeId;
        }
        
        public int getValue() {
            return typeId;
        }
    }
    
}
