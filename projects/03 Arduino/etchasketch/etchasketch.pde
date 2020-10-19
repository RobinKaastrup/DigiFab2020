import processing.serial.*;
Serial myPort;

int iterator = 0;
int cx;
int cy;

void setup() {
  size(1,1);
  surface.setResizable(true);
  colorMode(RGB, 255);
  
  
  surface.setSize(255, 255);
  
  println("available serial ports");
  println(Serial.list());
  myPort = new Serial(this, Serial.list()[0], 9600);

}

void draw() {
  byte[] inBuffer = new byte[1];
  if(myPort.available() > 0) {
    inBuffer = myPort.readBytes();
    myPort.clear();
    println(inBuffer);
    // å gjøre byte om til int type fikser overflow problemer
    cy = int(inBuffer[0]);
    cx = int(inBuffer[1]);
    
 
    
    rect(0,0,255,255);
    rect(cx, cy, 5,5);
    println();
    
  }
}
