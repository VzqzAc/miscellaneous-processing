import processing.video.*;

Capture webcam; //declares supposed webcam to use
PImage techissuesimg;
boolean floppy;

void setup() {
	size(640, 480);
	floppy = true;
	String[] cameras = Capture.list();

	techissuesimg = loadImage("data/techissues.jpg");
	webcam = new Capture(this, cameras[0]);
	webcam.start();
}

void draw() {
	if(webcam.available() && floppy) {
		webcam.read();
		image(webcam, 0, 0);
		PImage img = webcam.get();
		img.save("data/example.jpg");
		floppy = !floppy;
		webcam.stop();
	}
	image(techissuesimg, 0, 0, width, height);

}