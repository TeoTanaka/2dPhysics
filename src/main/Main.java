package main;

import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public static Main app;

    public static ArrayList<Point> points  = new ArrayList<Point>();
    public static ArrayList<Stick> sticks  = new ArrayList<Stick>();
    public static ArrayList<Box> boxes  = new ArrayList<Box>();


    public final float GRAVITY = 20;
    public final float AIR_RESIST = 1f;



    public Box b = new Box(250,250,100,100);
    public Box b2 = new Box(225,0,100,100);

    public float dt,lastTime;

    public final int screenW = 500, screenH = 500;

    public void settings() {
        size(screenW, screenH);
    }

    public void setup(){
        app=this;
//        for (int i = 0; i < Math.random()*10; i++){
//            Box box = new Box((float) (Math.random()*400)+100,(float) (Math.random()*400)+100,(float) (Math.random()*100),100);
//        }
    }

    public void draw(){
        frameRate(60);
        int now = millis();
        dt = (float) ((now - lastTime) / 1000.0);  // In seconds
        lastTime = now;
        background(0);
       for (Point p : points){
           p.update(dt);
       }
       for (Stick s : sticks){
           s.update();
       }
       for (Box b : boxes){
            b.update();
       }



        stroke(255);
        line(0,250,500,250);

    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}