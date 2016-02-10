package roguelike;

import graphics.PlayerGraphics;
import graphics.Graphics;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class GameWindow extends Group {
    
    private ImageView[][] map;
    
    public GameWindow() {
        map = new ImageView[20][20];
        Image imageSpace = new Image(Graphics.ImgURL.Space.getValue());
        GridPane root = new GridPane();
        getChildren().add(root);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = new ImageView(imageSpace);
                root.add(map[i][j], i, j);
            }
        }
        PlayerGraphics player = new PlayerGraphics();
        player.setX(10);
        player.setY(10);
        map[10][10].setImage(player.getImage());
//        for (int i = 0; i < 20; i++) {
//            map[i][0].setImage(new Image(Graphics.ImgURL.Wall.getValue()));
//            map[i][19].setImage(new Image(Graphics.ImgURL.Wall.getValue()));
//            map[0][i].setImage(new Image(Graphics.ImgURL.Wall.getValue()));
//            map[19][i].setImage(new Image(Graphics.ImgURL.Wall.getValue()));
//        }
        RogueLike.primaryStage.getScene().setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:
                    map[player.getX()][player.getY()].setImage(imageSpace);
                    player.moveUp();
                    map[player.getX()][player.getY()].setImage(player.getImage());
                    break;
                case DOWN:
                    map[player.getX()][player.getY()].setImage(imageSpace);
                    player.moveDown();
                    map[player.getX()][player.getY()].setImage(player.getImage());
                    break;
                case LEFT:
                    map[player.getX()][player.getY()].setImage(imageSpace);
                    player.moveLeft();
                    map[player.getX()][player.getY()].setImage(player.getImage());
                    break;
                case RIGHT:
                    map[player.getX()][player.getY()].setImage(imageSpace);
                    player.moveRight();
                    map[player.getX()][player.getY()].setImage(player.getImage());
                    break;
                default:
            }
        });
    }
    
}
