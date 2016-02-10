package graphics;

import javafx.scene.image.Image;

public abstract class Graphics {
    
    private Image image;
    
    private int x;
    private int y;
    
    public static enum ImgURL {
        Player("graphics/resources/player.png"),
        Space("graphics/resources/space.png"),
        Wall("graphics/resources/wall.png");
        
        private final String imageURL;
        
        ImgURL(String imageURL) {
            this.imageURL = imageURL;
        }
        
        public String getValue() {
            return imageURL;
        }
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setCoodinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
    
    public Image getImage() {
        return image;
    }
    
}
