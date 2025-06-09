package main;

import java.util.Arrays;

public class Box {
    private float width,height;
    private Point[] points;
    private Stick[] sticks;
    private Vector2 center = new Vector2();

    private Vector2 dim = new Vector2();
    private Vector2 pos = new Vector2();


    private float touchRadius;

    private float mass, elasticity;

    private int originIndex;

    public Box(float x, float y, float dimX, float dimY){
        this.pos.x = x;
        this.pos.y = y;
        this.dim.x = dimX;
        this.dim.y = dimY;
        initSelf();
        Main.boxes.add(this);
    }
    public void update(){
        updatePos();
        System.out.println(pos.x+" "+pos.y);
    }





    public void initSelf(){
        originIndex = Main.points.size();
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
        touchRadius = (points[0].getPos().distance(points[1].getPos()))/2;//furthest another box can be while touching

        for (Point p : points){
            p.addSelf();
        }
        for (Stick s: sticks){
            s.addSelf();
        }

    }
    public float getTouchRadius(){
        return touchRadius;
    }
    public Vector2 getCenter(){
        return center;
    }

    public Vector2 getPos(){
        return new Vector2(pos);
    }
    public Vector2 getDim(){
        return new Vector2(dim);
    }
    public void updatePos(){
        pos = Main.points.get(originIndex).getPos();
    }



}
