package main;

public class EulerPoint {

    private Vector2 pos = new Vector2();
    private float mass;
    private Vector2 vel = new Vector2();

    private float forceX, forceY = 60, elasticity;

    public EulerPoint(float x, float y, float mass, float elasticity){
        pos.x = x;
        pos.y = y;
        this.mass = mass;
        this.elasticity = elasticity;//needs to be 0 to 1
    }
    public EulerPoint(float x, float y, float mass){
        pos.x = x;
        pos.y = y;
        this.mass = mass;
        this.elasticity =1;// elasticity;//needs to be 0 to 1
    }

    public void update(float dt){
        constrain();
        updatePos(dt);
        //System.out.println("force x:"+forceX+"  force y:"+forceY);
        render();
    }
    public void render(){
        Main.app.noStroke();
        Main.app.fill(255);
        Main.app.ellipse(pos.x,pos.y,5,5);
    }
    public void updatePos(float dt){
        // Gravity
        forceY += 5f;

        float accX = forceX / mass;
        float accY = forceY / mass;

        vel.x += accX * dt;//velocity before updating position, semi- implicit euler
        vel.y += accY * dt;

        //System.out.println("velX: "+vel.x+" velY: "+ vel.y);


        pos.x  += vel.x * dt;
        pos.y  += vel.y * dt;

        forceX = 0.0f;
        forceY = 0.0f;
    }

    public void constrain(){
        if (pos.y > Main.app.screenH){

            pos.y = Main.app.screenH;
            vel.y *=-elasticity;

        }else if ( pos.y < 0){
            pos.y = 0;
            vel.y *=-elasticity;
        }
        if (pos.x > Main.app.screenW){
            pos.x = Main.app.screenW;
            vel.x *=-elasticity;

        }else if (pos.x < 0){
            pos.x = 0;
            vel.x *=-elasticity;
        }

    }
    public void addForce(Vector2 forces){
        forceX += forces.x;
        forceY += forces.y;

    }

    public Vector2 getPos(){
        return pos;
    }

    public Vector2 getVel(){
        return vel;
    }

    public float getMass() {return mass;}
    public void setMass(float n) { mass = n;}

    public void setElasticity(float n){elasticity = n;}


}
