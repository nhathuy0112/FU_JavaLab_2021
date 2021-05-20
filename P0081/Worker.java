package P0081;

public class Worker extends Bee {
    public Worker(String kind){
        super(kind);
    }

    public void setDead(float health){
        if(this.health < 70)
            isDead = true;
    }
}
