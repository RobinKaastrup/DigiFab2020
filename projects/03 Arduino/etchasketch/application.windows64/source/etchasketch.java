import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.serial.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class etchasketch extends PApplet {


Serial myPort;

int iterator = 0;
int cx;
int cy;

public void setup() {
  
  surface.setResizable(true);
  colorMode(RGB, 255);
  
  
  surface.setSize(255, 255);
  
  println("available serial ports");
  println(Serial.list());
  myPort = new Serial(this, Serial.list()[0], 9600);

}

public void draw() {
  byte[] inBuffer = new byte[1];
  if(myPort.available() > 0) {
    inBuffer = myPort.readBytes();
    myPort.clear();
    println(inBuffer);
    // å gjøre byte om til int type fikser overflow problemer
    cy = PApplet.parseInt(inBuffer[0]);
    cx = PApplet.parseInt(inBuffer[1]);
    
 
    
    rect(0,0,255,255);
    rect(cx, cy, 5,5);
    println();
    
  }
}
  public void settings() {  size(1,1); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "etchasketch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
