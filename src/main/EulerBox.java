package main;

public class EulerBox {

    private float mass,elasticity,resistance;
    private EulerPoint[] points;

    private EulerStick[] sticks;

    private Vector2 pos,dim;


    public EulerBox(Vector2 pos, Vector2 dim, float mass, float elasticity, float resistance){
        this.dim = dim;
        this.pos = pos;
        this.mass = mass;
        this.elasticity = elasticity;
        this.resistance = resistance;
        initSelf();
    }



    public void update(float dt){
        for (EulerStick s : sticks){
            s.update(dt);
        }
    }
    public void initSelf(){

        points = new EulerPoint[]{
                new EulerPoint(pos.x, pos.y, mass, elasticity),
//                new EulerPoint(pos.x + dim.x, pos.y, mass, elasticity),
//                new EulerPoint(pos.x + dim.x, pos.y + dim.y, mass, elasticity),
//                new EulerPoint(pos.x, pos.y + dim.y, mass, elasticity),
        };


        sticks = new EulerStick[]{
                new EulerStick(points[0], points[1], resistance, mass, elasticity),
//                new EulerStick(points[1], points[2], resistance, mass, elasticity),
//                new EulerStick(points[2], points[3], resistance, mass, elasticity),
//                new EulerStick(points[3], points[0], resistance, mass, elasticity),
//                new EulerStick(points[1], points[3], resistance, mass, elasticity),
//                new EulerStick(points[0], points[2], resistance, mass, elasticity),
        };
    }

}
