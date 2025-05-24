package main;

public class Point {
    private float x;
    private float y;
    private final float mass;
    private float velocityX = 0;
    private float velocityY = 0;

    private int forceX, forceY = 60;

    public Point(int x, int y, int mass){
        this.x = x;
        this.y = y;
        this.mass = mass;
    }

    public void update(float dt){
        constrain();
        updatePos(dt);
        System.out.println("velY:"+velocityY);
        render();
    }
    public void render(){
        Main.app.fill(255);
        Main.app.ellipse(x,y,5,5);
    }
    public void updatePos(float dt){
        float accX = forceX / mass;
        float accY = forceY / mass;

        velocityX += accX * dt;//velocity before updating position, semi- implicit euler
        velocityY += accY * dt;


        x = x + velocityX * dt;
        y = y + velocityY * dt;
    }

    public void constrain(){
        if (y > Main.app.screenH){

            y = Main.app.screenH;
            velocityY *=-1;

        }else if ( y < 5){
            y = 0;
            velocityY *=-1;
        }
        if (x > Main.app.screenW){
            x = Main.app.screenW;
            velocityX *=-1;

        }else if (x < 0){
            x = 0;
            velocityX *=-1;
        }

    }

}
