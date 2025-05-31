package main;

public class Point {

    private Vector2 pos = new Vector2();
    private final float mass;
    private Vector2 vel = new Vector2();

    private int forceX, forceY = 60;

    public Point(int x, int y, int mass){
        pos.x = x;
        pos.y = y;
        this.mass = mass;
    }

    public void update(float dt){
        constrain();
        updatePos(dt);
        System.out.println("x:"+pos.x+"  y:"+pos.y);
        render();
    }
    public void render(){
        Main.app.noStroke();
        Main.app.fill(255);
        Main.app.ellipse(pos.x,pos.y,5,5);
    }
    public void updatePos(float dt){
        float accX = forceX / mass;
        float accY = forceY / mass;

        vel.x += accX * dt;//velocity before updating position, semi- implicit euler
        vel.y += accY * dt;


        pos.x  += vel.x * dt;
        pos.y  += vel.y * dt;
    }

    public void constrain(){
        if (pos.y > Main.app.screenH){

            pos.y = Main.app.screenH;
            vel.y *=-1;

        }else if ( pos.y < 5){
            pos.y = 0;
            vel.y *=-1;
        }
        if (pos.x > Main.app.screenW){
            pos.x = Main.app.screenW;
            vel.x *=-1;

        }else if (pos.x < 0){
            pos.x = 0;
            vel.x *=-1;
        }

    }

    public Vector2 getPos(){
        return pos;
    }

}
