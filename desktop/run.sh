#!/bin/bash
set -e
# Compile and run a desktop version of the animations
BASEDIR=$(dirname "$0")
SRC_DIR="$BASEDIR/src"
LIB="$BASEDIR/core.jar"
OUT_DIR="$BASEDIR/out"
mkdir -p "$OUT_DIR"
# Compile sources from desktop/src and shared util classes
find "$SRC_DIR" "$BASEDIR/../app/src/main/java/Util" "$BASEDIR/../app/src/main/java/drawableObjects" -name '*.java' | \
  xargs javac -classpath "$LIB" -d "$OUT_DIR"
# Choose which main class to run
MAIN_CLASS="processing.test.draw_stick_figure_anim.desktop.LaunchAnimationDesktop"
if [ "$1" = "draw" ]; then
  MAIN_CLASS="processing.test.draw_stick_figure_anim.desktop.DrawStickFigureAnimDesktop"
fi
java -classpath "$OUT_DIR":"$LIB" "$MAIN_CLASS"
