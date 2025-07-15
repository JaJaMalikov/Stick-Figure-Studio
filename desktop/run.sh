#!/bin/bash
set -e
# Simple script to compile and run the desktop version of the launch animation
BASEDIR=$(dirname "$0")
SRC_DIR="$BASEDIR/src"
LIB="$BASEDIR/core.jar"
OUT_DIR="$BASEDIR/out"
mkdir -p "$OUT_DIR"
javac -classpath "$LIB" -d "$OUT_DIR" $(find "$SRC_DIR" -name '*.java')
# Launch the full desktop application starting with the launch animation
java -classpath "$OUT_DIR":"$LIB" processing.test.draw_stick_figure_anim.desktop.DesktopMain
