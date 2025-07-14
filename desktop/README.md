# Desktop Port

This folder contains Processing sketches ported from the Android version so they can
be run on a regular desktop JVM. Use the provided `run.sh` script to compile and
execute any of the sketches.

```
./run.sh [full.class.Name]
```

If no class name is supplied, the classic `DrawStickFigureAnimDesktop` sketch is
started. To run the launch animation, pass its class name:

```
./run.sh processing.test.draw_stick_figure_anim.desktop.LaunchAnimationDesktop
```

The script requires a local Java JDK and the Processing core library (`core.jar`).
