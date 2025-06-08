package main;

import java.util.Arrays;

public class Box {
    private float width,height;
    private Point[] points;
    private Stick[] sticks;

    private Vector2 dim = new Vector2();
    private Vector2 pos = new Vector2();

    private float mass, elasticity;

    public Box(float x, float y, float dimX, float dimY){
        this.pos.x = x;
        this.pos.y = y;
        this.dim.x = dimX;
        this.dim.y = dimY;
        initSelf();
    }
    public void update(){

    }


    public void initSelf(){
        this.points = new Point[]{
                new Point(pos),
                new Point(pos.x + dim.x, pos.y),
                new Point(pos.x, pos.y + dim.y),
                new Point(pos.x + dim.x, pos.y + dim.y)
        };
        this.sticks = new Stick[]{
                new Stick(points[0],points[1]),
                new Stick(points[2],points[3]),
                new Stick(points[0],points[2]),
                new Stick(points[1],points[3]),
                new Stick(points[0],points[3]),
                new Stick(points[1],points[2]),
        };
        for (Point p : points){
            p.addSelf();
        }
        for (Stick s: sticks){
            s.addSelf();
        }

    }



}
