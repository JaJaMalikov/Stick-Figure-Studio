package processing.test.draw_stick_figure_anim.desktop;

import processing.core.PApplet;

/**
 * Desktop entry point mirroring the Android MainActivity.
 * It launches the full application starting with the launch animation.
 */
public class DesktopMain {
    public static void main(String[] args) {
        PApplet.main(LaunchAnimationDesktop.class.getName());
    }
}
