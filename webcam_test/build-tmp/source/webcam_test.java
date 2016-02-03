import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class webcam_test extends PApplet {



Capture webcam; //declares supposed webcam to use

public void setup() {
	

	String[] cameras = Capture.list();

	webcam = new Capture(this, cameras[0]);
	webcam.start();
}

public void draw() {
	if(webcam.available()) {
		webcam.read();
		image(webcam, 0, 0);
		PImage img = webcam.get();
	}

	image(webcam, 0, 0);

}
  public void settings() { 	size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "webcam_test" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
