package main;

import processing.core.PApplet;

public class Main extends PApplet {
    public static Main app;

    public void settings() {
        size(500, 500);
    }

    public void setup(){
        app=this;
    }

    public void draw(){
        background(0);

    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}