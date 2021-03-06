import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sound_example extends PApplet {



// * Five sine waves are layered to construct a cluster of frequencies. 
//  * This method is called additive synthesis. Use the mouse position 
//  * inside the display window to detune the cluster.

SinOsc[] sineWaves; //Array of sines
float[] sineFreq; //Array of frequencies
int numSines = 5;

public void setup() {
	
	background(255, 25);

	sineWaves = new SinOsc[numSines]; //Init the oscillators
	sineFreq = new float[numSines]; //Init array of frequencies
	for (int i = 0; i < numSines; i++) {
		//Calculate the amplitude of each oscillator
		float sineVolume = (1.0f / numSines) / (i + 1);
		//Create the oscillators
		sineWaves[i] = new SinOsc(this);
		//Start oscillators
		sineWaves[i].play();
		//Set the amplitude for all oscillators
		sineWaves[i].amp(sineVolume);
	}
}

public void draw() {
  //Map mouseY from 0 to 1
  float yoffset = map(mouseY, 0, height, 0, 1);
  //Map mouseY logarithmically to 150 - 1150 to create a base frequency range
  float frequency = pow(1000, yoffset) + 150;
  //Use mouseX mapped from -0.5 to 0.5 as a detune argument
  float detune = map(mouseX, 0, width, -0.5f, 0.5f);

  for (int i = 0; i < numSines; i++) { 
    sineFreq[i] = frequency * (i + 1 * detune);
    // Set the frequencies for all oscillators
    sineWaves[i].freq(sineFreq[i]);
  }
}
  public void settings() { 	size(640, 360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sound_example" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
