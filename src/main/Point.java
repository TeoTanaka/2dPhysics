package main;

public class Point {
    private Vector2 pos, oldPos;
    private Vector2 force = new Vector2();
    private float mass,elasticity;

    public Point(Vector2 pos, Vector2 oldPos, float mass, float elasticity){
        this.pos = pos;
        this.oldPos = oldPos;
        this.mass = mass;
        this.elasticity = elasticity;
    }
    public Point(Vector2 pos, Vector2 oldPos){
        this.pos = pos;
        this.oldPos = oldPos;
        this.mass = 1;
        this.elasticity = 1;
    }

    public void update(float dt){
        constrain();
        updatePos(dt);

        //System.out.println("x:"+ pos.x+" y:"+pos.y);
        render();
    }
    public void render(){
        Main.app.fill(255,0,0);
        Main.app.noStroke();
        Main.app.ellipse(pos.x,pos.y,5,5);
    }

    public void updatePos(float dt){
        Vector2 acc = new Vector2();
        acc.x = force.x / mass * Main.app.AIR_RESIST;
        acc.y = force.y / mass * Main.app.AIR_RESIST;

        Vector2 vel = new Vector2();
        vel.x = pos.x- oldPos.x ;
        vel.y = pos.y- oldPos.y ;

        force.x = 0;
        force.y = Main.app.GRAVITY;//apply forces


        oldPos.x = pos.x;
        oldPos.y = pos.y;

        pos.x += vel.x + acc.x *dt*dt;
        pos.y += vel.y + acc.y *dt*dt;
        constrain();
    }
    public void constrain(){
        Vector2 vel = new Vector2();
        vel.x = pos.x- oldPos.x;
        vel.y = pos.y- oldPos.y;

        if (pos.y > Main.app.screenH){

            pos.y = Main.app.screenH;
            oldPos.y = pos.y+vel.y*elasticity;

        }else if ( pos.y < 0){
            pos.y = 0;
            oldPos.y = pos.y+vel.y*elasticity;
        }
        if (pos.x > Main.app.screenW){
            pos.x = Main.app.screenW;
            oldPos.x = pos.x+vel.x*elasticity;

        }else if (pos.x < 0){
            pos.x = 0;
            oldPos.x = pos.x+vel.x*elasticity;
        }
    }

    public Vector2 getPos(){
        return pos;
    }

    public void setPos(Vector2 p){
        pos = p;
    }


}