package processing.test.draw_stick_figure_anim.desktop;

import processing.core.PApplet;

/**
 * Simple desktop sketch representing the main menu.
 * Clicking anywhere launches the stick figure animation.
 */
public class MenuSketchDesktop extends PApplet {

    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(64);
        background(255);
        fill(0);
        text("Menu", width/2f, height/2f);
    }

    public void draw() {
        // nothing animated here
    }

    public void mousePressed() {
        // start the drawing sketch when the user clicks
        PApplet.main(DrawStickFigureAnimDesktop.class.getName());
        exit();
    }

    public void settings() {
        size(1920, 1080);
    }

    public static void main(String[] args) {
        PApplet.main(MenuSketchDesktop.class.getName());
    }
}
