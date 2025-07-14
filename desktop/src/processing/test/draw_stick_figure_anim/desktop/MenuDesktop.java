package processing.test.draw_stick_figure_anim.desktop;

import processing.core.PApplet;

/**
 * Simple menu placeholder for the desktop port.
 */
public class MenuDesktop extends PApplet {

    @Override
    public void settings() {
        size(1080, 1920);
    }

    @Override
    public void setup() {
        background(255);
        textAlign(CENTER, CENTER);
        textSize(64);
        fill(0);
        text("Menu", width / 2f, height / 2f);
    }

    @Override
    public void draw() {
        // Nothing to animate for now
    }

    public static void main(String[] args) {
        PApplet.main(MenuDesktop.class.getName());
    }
}
