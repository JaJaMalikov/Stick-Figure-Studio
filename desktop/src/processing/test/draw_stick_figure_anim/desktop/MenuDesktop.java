package processing.test.draw_stick_figure_anim.desktop;

import processing.core.PApplet;

/**
 * Simple placeholder menu screen for the desktop version.
 * Displays a message and exits on key press.
 */
public class MenuDesktop extends PApplet {

    public void settings() {
        size(1920, 1080);
    }

    public void setup() {
        textAlign(CENTER, CENTER);
        textSize(64);
        background(255);
    }

    public void draw() {
        background(255);
        fill(0);
        text("Menu Screen - press any key", width/2f, height/2f);
    }

    public void keyPressed() {
        exit();
    }

    public static void main(String[] args) {
        PApplet.main(MenuDesktop.class.getName());
    }
}
