package main;

import processing.core.PApplet;

public class Main extends PApplet {
    public static Main app;

    //public Box b = new Box(new Vector2(250,250),new Vector2(100,100),1f,1f,100f);

    //public EulerStick s = new EulerStick(new EulerPoint(100,100,1),new EulerPoint(200,200,1),100f,1f,1f);

    public Point p = new Point(new Vector2(250,250), new Vector2(250,250));

    public final float GRAVITY = 20;
    public final float AIR_RESIST = 1f;





    public float dt,lastTime;

    public final int screenW = 500, screenH = 500;

    public void settings() {
        size(screenW, screenH);
    }

    public void setup(){
        app=this;
    }

    public void draw(){
        frameRate(60);
        int now = millis();
        dt = (float) ((now - lastTime) / 1000.0);  // In seconds
        lastTime = now;
        background(0);
        //point.update(dt);
        p.update(dt);


        stroke(255);
        line(0,250,500,250);

    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}