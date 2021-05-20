package P0081;

public class Drone extends Bee {
    public Drone(String kind){
        super(kind);
    }

    public void setDead(float health){
        if(this.health < 50)
            isDead = true;
    }
}
