package roguelike;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MainMenu extends Group { 
    
    private Canvas canvas;
    private GraphicsContext gc;
    
    static double WIDTH = 700;
    static double HEIGHT = 700;
    
    static final String FONTFAMILY = "Verdana";
    static final double FONTSIZE = 24;

    public enum TextColor {
        Normal(Color.BLUE),
        Hover(Color.RED),
        Pressed(Color.BLACK);
        
        private final Color color; 
        
        TextColor(Color color) {
            this.color = color;
        }
        
        public Color getValue() {
            return color;
        }
    }

    MainMenu() {
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        
//        Canvas canvasBackground = new Canvas(WIDTH, HEIGHT);
//        GraphicsContext gcBackground = canvasBackground.getGraphicsContext2D();
//        gcBackground.setFill(Color.GAINSBORO);
//        gcBackground.fillRect(0, 0, WIDTH, HEIGHT);
//        canvasBackground.toBack();

        getChildren().addAll(canvas);
        createMenu();
    }
    
    private void createMenu() {
        drawDShape();
        drawRadialGradient(Color.GREEN, Color.BLUE);
        drawLinearGradient(Color.RED, Color.PURPLE);
        drawDropShadow(Color.LIME, Color.BLACK, Color.DARKBLUE, Color.DARKGREEN);
        
        double x = 50;
        double y = 250;
        double diff = 40;
        Text textNewGame = createText(x, y, "New Game");
        Text textSettings = createText(x, y+diff, "Settings");
        Text textExit = createText(x, y+2*diff, "Exit");
        
        textNewGame.setOnMouseClicked((MouseEvent event) -> {
            GameWindow gameWindow = new GameWindow();
            getScene().setRoot(gameWindow);
        });
        textSettings.setOnMouseClicked((MouseEvent event) -> {
            getChildren().removeAll(textNewGame, textSettings, textExit);
            getChildren().add(new Text(100, 250, "Nothing there"));
            createSettings();
        });
        textExit.setOnMouseClicked((MouseEvent event) -> {
            System.exit(0);
        });
        getChildren().addAll(textNewGame, textSettings, textExit);
        
        Rectangle rect = createRect();
        getChildren().add(rect);
    }
    
    private void createSettings() {
        Text textFullScreen = createText(200, 250, "Full-screen");
        ToggleButton tbOn = new ToggleButton("On");
        tbOn.setTranslateX(200);
        tbOn.setTranslateY(280);
        ToggleButton tbOff = new ToggleButton("Off");
        tbOff.setTranslateX(200 + 40);
        tbOff.setTranslateY(280);
        ToggleGroup groupFullScreen = new ToggleGroup();
        tbOn.setToggleGroup(groupFullScreen);
        tbOff.setToggleGroup(groupFullScreen);
        groupFullScreen.selectToggle(tbOff);
        tbOn.setOnAction((ActionEvent event) -> {
            RogueLike.primaryStage.setFullScreen(tbOn.isSelected());
        });
        tbOff.setOnAction((ActionEvent event) -> {
            RogueLike.primaryStage.setFullScreen(tbOn.isSelected());
        });
        RogueLike.primaryStage.setFullScreenExitHint("");
        getChildren().addAll(textFullScreen, tbOn, tbOff);
    }
    
    private Text createText(double x, double y, String text) {
        Text t = new Text (x, y, text);
        t.setFont(Font.font (FONTFAMILY, FontWeight.BOLD, FONTSIZE));
        t.setFill(TextColor.Normal.getValue());
        
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(8);
        innerShadow.setOffsetY(8);
        innerShadow.setColor(Color.web("0x3b596d"));
        t.setEffect(innerShadow);
        
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-135.0);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);
        t.setEffect(lighting);
        
        t.setOnMouseEntered((MouseEvent event) -> {
            t.setFill(TextColor.Hover.getValue());
        });
        t.setOnMouseExited((MouseEvent event) -> {
            t.setFill(TextColor.Normal.getValue());
        });
        t.setOnMousePressed((MouseEvent event) -> {
            t.setFill(TextColor.Pressed.getValue());
        });
        t.setOnMouseReleased((MouseEvent event) -> {
            t.setFill(TextColor.Hover.getValue());
        });
        
        return t;
    }
    
    private Rectangle createRect() {
        Rectangle rect = new Rectangle(20, 20, 100, 100);
        rect.setTranslateX(400);
        rect.setTranslateY(20);
        rect.setArcHeight(20);
        rect.setArcWidth(20);
        rect.setFill(Color.ORANGE);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(4));
        rotateTransition.setNode(rect);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(720);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        
        rotateTransition.play();
        rect.setOnMouseEntered((MouseEvent event) -> {
            rotateTransition.pause();
        });
        rect.setOnMouseExited((MouseEvent event) -> {
            rotateTransition.play();
        });
        
        return rect;
    }
    
    private void drawDShape() {
        gc.beginPath();
        gc.moveTo(50, 50);
        gc.bezierCurveTo(150, 20, 150, 150, 75, 150);
        gc.closePath();
    }
    
    private void drawRadialGradient(Color firstColor, Color lastColor) {
        gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
                   CycleMethod.REFLECT,
                   new Stop(0.0, firstColor),
                   new Stop(1.0, lastColor)));
        gc.fill();
    }
    
    private void drawLinearGradient(Color firstColor, Color secondColor) {
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
                            CycleMethod.REFLECT,
                            new Stop(0.0, firstColor),
                            new Stop(1.0, secondColor));
        gc.setStroke(lg);
        gc.setLineWidth(20);
        gc.stroke();
    }
    
    private void drawDropShadow(Color firstColor, Color secondColor,
                                Color thirdColor, Color fourthColor) {
        gc.applyEffect(new DropShadow(20, 20, 0, firstColor));
        gc.applyEffect(new DropShadow(20, 0, 20, secondColor));
        gc.applyEffect(new DropShadow(20, -20, 0, thirdColor));
        gc.applyEffect(new DropShadow(20, 0, -20, fourthColor));
    }
    
}
