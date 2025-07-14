package processing.test.draw_stick_figure_anim.desktop;

import DrawableObjects.StickFigure;
import Util.Drawer;
import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;
import java.util.List;

/**
 * Desktop entry point showing the launch animation without Android dependencies.
 */
public class LaunchAnimationDesktop extends PApplet {
    /** Callback executed when the launch sequence finishes. */
    private Runnable onFinish;

    /**
     * Launch the animation and run {@code onFinish} when it completes.
     */
    public static void start(Runnable onFinish) {
        LaunchAnimationDesktop sketch = new LaunchAnimationDesktop();
        sketch.onFinish = onFinish;
        PApplet.runSketch(new String[]{}, sketch);
    }

    private PFont f;
    private int startTime;
    private int lastTime;
    private Drawer drawer;
    private Drawer.ColorVector background;
    private StickFigure stickFigure;
    private List<RotatedChar> title;

    public void setup() {
        double lastXPos = width/9f;
        double lastYPos = height/9f + 60;
        title = new ArrayList<>();
        title.add(new RotatedChar('S', lastXPos, lastYPos, -0.55f));
        title.add(new RotatedChar('T', lastXPos+=65, lastYPos-=39, -.28f));
        title.add(new RotatedChar('I', lastXPos+=90, lastYPos-=25, -.25f));
        title.add(new RotatedChar('C', lastXPos+=45, lastYPos-=12, -0.12f));
        title.add(new RotatedChar('K', lastXPos+=95, lastYPos-=7, -0.05f));
        lastXPos = width/9f;
        title.add(new RotatedChar('F', lastXPos, lastYPos+=240, -0.50f));
        title.add(new RotatedChar('I', lastXPos+=75, lastYPos-=35, -0.38f));
        title.add(new RotatedChar('G', lastXPos+=44, lastYPos-=22, -0.25f));
        title.add(new RotatedChar('U', lastXPos+=105, lastYPos-=24, -0.20f));
        title.add(new RotatedChar('R', lastXPos+=100, lastYPos-=17, -0.14f));
        title.add(new RotatedChar('E', lastXPos+=102, lastYPos-=10, -0.05f));
        lastXPos = width/9f + 42;
        title.add(new RotatedChar('S', lastXPos, lastYPos+=250, -0.55f));
        title.add(new RotatedChar('T', lastXPos+=72, lastYPos-=30, -0.35f));
        title.add(new RotatedChar('U', lastXPos+=80, lastYPos-=27, -0.23f));
        title.add(new RotatedChar('D', lastXPos+=95, lastYPos-=22, -0.17f));
        title.add(new RotatedChar('I', lastXPos+=104, lastYPos-=17, -0.14f));
        title.add(new RotatedChar('O', lastXPos+=45, lastYPos-=5, -0.10f));

        f = createFont("Serif.bold", 28, true);
		if (f == null) f = createFont("SansSerif", 28, true);
        textFont(f);
        background = new Drawer.ColorVector(255, 255, 0);
        background(background.R(), background.G(), background.B());
        drawMiniStickFigures();
        for(RotatedChar c : title){
            c.drawText();
        }
        drawLoadingText(width/2, (int)(height * 4.0/5.0));
        stickFigure = new StickFigure(width/2, height/2);
        drawer = new Drawer(this);
        drawer.drawStickFigure(stickFigure);
        lastTime = millis();
        startTime = millis();
    }

    public void draw(){
        noStroke();
        if((millis() - lastTime) < 1000){
            fill(0);
            ellipse(width/2f, height - 440, 50, 50);
            ellipse(width/2f + 80, height - 440, 50, 50);
            fill(0, 100, 255);
            ellipse(width/2f - 80, height - 440, 50, 50);
        }else if(((millis() - lastTime) >= 1000) && (millis() - lastTime) <= 2000){
            fill(0);
            ellipse(width/2f - 80, height - 440, 50, 50);
            ellipse(width/2f + 80, height - 440, 50, 50);
            fill(0, 100, 255);
            ellipse(width/2f, height - 440, 50, 50);
        }else if(((millis() - lastTime) >= 2000 && (millis() - lastTime) <= 3000)){
            fill(0);
            ellipse(width/2f - 80, height - 440, 50, 50);
            ellipse(width/2f, height - 440, 50, 50);
            fill(0, 100, 255);
            ellipse(width/2f + 80, height - 440, 50, 50);
        }else{
            lastTime = millis();
        }

        if((millis() - startTime) > 8000){
            if(onFinish != null){
                onFinish.run();
            }
            exit();
        }
    }

    public void drawLoadingText(int xPos, int yPos){
        noStroke();
        fill(0);
        textSize(90);
        textAlign(CENTER);
        text("Loading", xPos, yPos + 100);
    }

    public void drawMiniStickFigures(){
        fill(0);
        strokeWeight(5);
        ellipse(width/9f + 500 , height/9f - 54, 20, 20);
        line(width/9f + 500, height/9f - 54, width/9f + 475, height/9f - 19);
        line(width/9f + 475, height/9f - 19, width/9f + 485, height/9f + 6);
        line(width/9f + 475, height/9f - 19, width/9f + 460, height/9f + 6);
        line(width/9f + 489, height/9f - 39, width/9f + 462, height/9f - 16);

        ellipse(width/9f + 222, height/9f + 195, 20, 20);
        line(width/9f + 222, height/9f + 195, width/9f + 222, height/9f + 235);
        line(width/9f + 222, height/9f + 218, width/9f + 195, height/9f + 197);
        line(width/9f + 222, height/9f + 235, width/9f + 244, height/9f + 251);
        line(width/9f + 222, height/9f + 235, width/9f + 233, height/9f + 256);

        ellipse(width/9f + 75, height/9f - 120, 20, 20);
        line(width/9f + 75, height/9f - 120, width/9f + 44, height/9f - 80);
        line(width/9f + 44, height/9f - 80, width/9f + 36, height/9f - 50);
        line(width/9f + 44, height/9f - 80, width/9f + 46, height/9f - 47);
        line(width/9f + 60, height/9f - 100, width/9f + 72, height/9f - 80);
        line(width/9f + 60, height/9f - 100, width/9f + 62, height/9f - 76);
    }

    private class RotatedChar {
        private double rotation;
        private double xPos;
        private double yPos;
        private char character;
        public RotatedChar(char character, double xPos, double yPos, double rotation){
            this.xPos = xPos;
            this.yPos = yPos;
            this.character = character;
            this.rotation = rotation;
        }
        public void drawText(){
            resetMatrix();
            pushMatrix();
            translate((float)this.xPos, (float)this.yPos);
            rotate((float)this.rotation);
            fill(0);
            textSize(140);
            text(this.character, 0, 0);
            popMatrix();
        }
    }

    public void settings() {
        // Landscape orientation for desktop usage
        size(1920, 1080);
    }

    public static void main(String[] args) {
        start(null);
    }
}
