package main;

public class Stick {

    private Point p1,p2;
    private float length,elasticity,mass;


    public Stick(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        this.length = p1.getPos().distance(p2.getPos());
        this.elasticity = 1;
        this.mass = 1;
    }

    public void update(float dt){
        render();
        p1.update(dt);
        p2.update(dt);
        restrainPoints();
    }

    public void render(){
        Main.app.stroke(255);
        Main.app.line(p1.getPos().x,p1.getPos().y,p2.getPos().x,p2.getPos().y);

    }
    public void restrainPoints(){
        Vector2 pos1 = p1.getPos().copy();  // safe copies
        Vector2 pos2 = p2.getPos().copy();

        Vector2 delta = pos2.sub(pos1);     // vector from p1 to p2
        float dist = delta.magnitude();     // current distance
        float diff = (dist - length) / dist; // normalized difference

        Vector2 offset = delta.mult(0.5f * diff); // move each point half the correction

        p1.setPos(pos1.add(offset));  // p1 moves toward p2
        p2.setPos(pos2.sub(offset));  // p2 moves toward p1


    }
}
