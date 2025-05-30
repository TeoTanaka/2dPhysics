package main;

public class VerletPoint {
    private float x,y,oldX,oldY;
    private final float mass;

    private int forceX=0, forceY = 60;

    public VerletPoint(int x, int y, int mass){
        this.x = x;
        this.y = y;
        oldX = x;
        oldY = y;
        this.mass = mass;
    }

    public void update(float dt){
        constrain();
        updatePos(dt);
        //System.out.println("x:"+x+"y:"+y);
        render();
    }
    public void render(){
        Main.app.fill(255);
        Main.app.ellipse(x,y,5,5);
    }
    public void updatePos(float dt){
        float accX = forceX / mass;
        float accY = forceY / mass;
        float tempX = x;
        float tempY = y;
        //System.out.println("y-oldY:"+(y-oldY)+" oldY:"+oldY+"Y:"+y);
        //System.out.println(forceY / mass);
        //System.out.println("vel X:"+ (x-oldX)+accX*(dt*dt)+" vel Y:"+ (y-oldY)+accY*(dt*dt));
        //System.out.println("accX:"+accX+"  accY: "+accY);
        x = x + x-oldX+accX*(dt*dt);
        y = y + y-oldY+accY*(dt*dt);
        oldX = tempX;
        oldY = tempY;

    }

    public void constrain(){
        float velX = (x- oldX);
        float velY = (y-oldY);
        if (y > Main.app.screenH){

            y = Main.app.screenH;
            y+=velY;


        }else if ( y < 0){
            y = 0;
            y+=velY;
        }
        if (x > Main.app.screenW){
            x = Main.app.screenW;
            x+=velX;

        }else if (x < 0){
            x = 0;
            x+=velX;
        }

    }

}
