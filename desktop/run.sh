#!/bin/bash
set -e
# Simple script to compile and run the desktop version of the launch animation
BASEDIR=$(dirname "$0")
SRC_DIR="$BASEDIR/src"
LIB="$BASEDIR/core.jar"
OUT_DIR="$BASEDIR/out"
mkdir -p "$OUT_DIR"
javac -classpath "$LIB" -d "$OUT_DIR" $(find "$SRC_DIR" "$BASEDIR/../app/src/main/java/Util" "$BASEDIR/../app/src/main/java/drawableObjects" -name '*.java')
java -classpath "$OUT_DIR":"$LIB" processing.test.draw_stick_figure_anim.desktop.DrawStickFigureAnimDesktop
