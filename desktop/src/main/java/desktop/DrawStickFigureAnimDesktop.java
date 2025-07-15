package desktop;

import processing.core.*;
import java.util.ArrayList;
import java.util.List;

public class DrawStickFigureAnimDesktop extends PApplet {

  int index = 0;
  PFont f;
  int animationStartTime;
  int lastCharStart;

  //store AnimatedChar values in lists
  List<AnimatedChar> charArray = null;
  List<AnimatedChar> activeCharArray = null;

  public void setup(){
    f = createFont("sans-serif", 30, true);
    animationStartTime = millis();
    lastCharStart = millis();
    charArray = new ArrayList<AnimatedChar>();
    activeCharArray = new ArrayList<AnimatedChar>();
    charArray.add(new AnimatedChar('D', width/2 - 450, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('R', width/2 - 390, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('A', width/2 - 330, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('W', width/2 - 270, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('Y', width/2 - 140, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('O', width/2 - 80, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('U', width/2 - 20, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('R', width/2 + 40, AnimatedChar.startHeight1));
    charArray.add(new AnimatedChar('S', width/2 - 353, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('T', width/2 - 293, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('I', width/2 - 233, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('C', width/2 - 203, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('K', width/2 - 143, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('F', width/2 - 13, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('I', width/2 + 47, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('G', width/2 + 77, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('U', width/2 + 137, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('R', width/2 + 197, AnimatedChar.startHeight2));
    charArray.add(new AnimatedChar('E', width/2 + 257, AnimatedChar.startHeight2));
    activeCharArray.add(charArray.get(index));
    index++;
    background(255);
  }

  public void draw(){
    background(255);
    int newTime = millis();
    for(AnimatedChar ac : activeCharArray){
      ac.drawChar();
    }
    if(activeCharArray.size() < charArray.size()){
      if(newTime - lastCharStart >= 80){
        activeCharArray.add(charArray.get(index));
        index++;
        lastCharStart = millis();
      }
    }
  }

  private class AnimatedChar{
    private static final int startHeight1 = 200;
    private static final int startHeight2 = 320;
    private double velocity;
    private final double acceleration = 0.035f;
    private final char character;
    private boolean completedAnimation = false;
    private int xPos;
    private int yPos;
    private int brightness;

    public AnimatedChar (char c, int xPos, int yPos){
      this.character = c;
      this.xPos = xPos;
      this.yPos = yPos;
      this.brightness = 0;
      this.velocity = 0;
    }

    public void drawChar(){
      if(!completedAnimation){
        if(brightness < 255){
          brightness += 6;
        }
        if(character == 'F' || character == 'I' || character == 'G' || character == 'U' || character == 'R' || character == 'E'){
          if(yPos > height/2){
            velocity += acceleration;
            yPos -= velocity;
          }else{
            completedAnimation = true;
          }
        }else{
          if(yPos < height/2){
            velocity += acceleration;
            yPos += velocity;
          }else{
            completedAnimation = true;
          }
        }
      }
      fill(brightness);
      textFont(f);
      textSize(65);
      textAlign(CENTER);
      text(character, xPos, yPos);
    }
  }

  public void settings() {
    size(1080, 1000);
  }

  public static void main(String[] passedArgs) {
    PApplet.main(DrawStickFigureAnimDesktop.class.getName());
  }
}
