package main;

public class Box {

    private float mass,elasticity,resistance;
    private Point[] points;

    private Stick[] sticks;

    private Vector2 pos,dim;


    public Box(Vector2 pos, Vector2 dim,float mass, float elasticity, float resistance){
        this.dim = dim;
        this.pos = pos;
        this.mass = mass;
        this.elasticity = elasticity;
        this.resistance = resistance;
        initSelf();
    }



    public void update(float dt){
        for (Stick s : sticks){
            s.update(dt);
        }
    }
    public void initSelf(){

        points = new Point[]{
                new Point(pos.x, pos.y, mass, elasticity),
                new Point(pos.x + dim.x, pos.y, mass, elasticity),
                new Point(pos.x + dim.x, pos.y + dim.y, mass, elasticity),
                new Point(pos.x, pos.y + dim.y, mass, elasticity),
        };


        sticks = new Stick[]{
                new Stick(points[0], points[1], resistance, mass, elasticity),
                new Stick(points[1], points[2], resistance, mass, elasticity),
                new Stick(points[2], points[3], resistance, mass, elasticity),
                new Stick(points[3], points[0], resistance, mass, elasticity),
                new Stick(points[1], points[3], resistance, mass, elasticity),
                new Stick(points[0], points[2], resistance, mass, elasticity),
        };
    }

}
