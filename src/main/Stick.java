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

    public void update(){

        render();
    }

    public void render(){
        Main.app.stroke(255);
        Main.app.line(p1.getX(),p1.getY(),p2.getX(),p2.getY());
    }
    public void connect(){
        
    }
}
