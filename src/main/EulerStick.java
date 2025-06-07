package main;

public class EulerStick {
    private EulerPoint p1, p2;

    float resistance, length, give = 10, damping, mass;

    public EulerStick(EulerPoint p1, EulerPoint p2, float dist, float resistance, float mass, float elasticity){
        this.p1 = p1;
        this.p2 = p2;
        p1.setElasticity(elasticity);
        p2.setElasticity(elasticity);
        p1.setMass(mass);
        p2.setMass(mass);
        this.mass = mass;
        this.resistance = resistance;
        this.length = dist;
        damping = .99f;
    }
    public EulerStick(EulerPoint p1, EulerPoint p2, float resistance, float mass, float elasticity){
        this.p1 = p1;
        this.p2 = p2;
        p1.setElasticity(elasticity);
        p2.setElasticity(elasticity);
        p1.setMass(mass);
        p2.setMass(mass);
        this.mass = mass;
        this.resistance = resistance;
        this.length = p1.getPos().distance(p2.getPos());
    }

    public void update(float dt){
        connect();
        p1.update(dt);
        p2.update(dt);
        render();
    }

    public void render(){
        Main.app.stroke(255);
        Vector2 pos1 = p1.getPos();
        Vector2 pos2 = p2.getPos();
        Main.app.line(pos1.x,pos1.y,pos2.x,pos2.y);
        Vector2 centerMass = pos1.mult(p1.getMass()).add(pos2.mult(p2.getMass()));
        Main.app.point(centerMass.x, centerMass.y);

    }
    public void connect(){
        float distance = p1.getPos().distance(p2.getPos());
        if (distance > length + give || distance < length - give){
            Vector2 dir1 = p2.getPos().sub(p1.getPos()); //direction for p1
            Vector2 dir2 = p1.getPos().sub(p2.getPos()); //direction for p2
            dir1 = dir1.normalize().mult(resistance).mult(distance-length);
            dir2 = dir2.normalize().mult(resistance).mult(distance-length);

            //System.out.println("forceX"+ dir1.x+"  forceY"+dir1.y);
            p1.addForce(dir1);
            p2.addForce(dir2);
            float dampingCoefficient1 = 1f;// * 2f * (float)Math.sqrt(p1.getMass() * resistance);
            float dampingCoefficient2 = 1f;// * 2f * (float)Math.sqrt(p2.getMass() * resistance);
            p1.addForce(p1.getVel().mult(-1f).mult(dampingCoefficient1));
            p2.addForce(p2.getVel().mult(-1f).mult(dampingCoefficient2));

        }

    }
}
