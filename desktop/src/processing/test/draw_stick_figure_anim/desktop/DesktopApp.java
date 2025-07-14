package processing.test.draw_stick_figure_anim.desktop;

import processing.core.PApplet;

/**
 * Simple desktop entry point launching the full application. It first shows the
 * launch animation and then transitions to the stick figure drawing animation.
 */
public class DesktopApp {
    public static void main(String[] args) {
        LaunchAnimationDesktop.start(() ->
                PApplet.runSketch(new String[]{}, new DrawStickFigureAnimDesktop()));
    }
}
