package main;

public class Vector2 {

    private float x;
    private float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 copy){
        this.x = copy.x;
        this.y = copy.y;
    }

    public Vector2 copy(){
        return new Vector2(this);
    }

    public float magnitude(){
        return (float)Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    public float distance(Vector2 other){
        float dx = this.x - other.x;
        float dy = this.y - other.y;
        return (float)Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
    }

    public float dot(Vector2 other){
        return this.x * other.x + this.y * other.y;
    }

    public float angle(){
        return (float)Math.atan2(this.y, this.x);
    }

    public Vector2 add(Vector2 other){
        return new Vector2(this.x + other.x, this.y + other.y);
    }


}
