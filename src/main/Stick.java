package main;

public class Stick {
    private Point p1, p2;

    float resistance, dist;

    public Stick(Point p1, Point p2, float dist, float resistance){
        this.p1 = p1;
        this.p2 = p2;
        this.resistance = resistance;
        this.dist = dist;
    }
    public Stick(Point p1, Point p2, float resistance){
        this.p1 = p1;
        this.p2 = p2;
        this.resistance = resistance;
        this.dist = p1.getPos().distance(p2.getPos());
    }

    public void update(float dt){
        p1.update(dt);
        p2.update(dt);
        render();
    }

    public void render(){
        Main.app.stroke(255);
        Vector2 pos1 = p1.getPos();
        Vector2 pos2 = p2.getPos();
        Main.app.line(pos1.x,pos1.y,pos2.x,pos2.y);

    }
    public void connect(){
        
    }
}
