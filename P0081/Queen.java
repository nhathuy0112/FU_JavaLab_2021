package P0081;

public class Queen extends Bee {
    public Queen(String kind){
        super(kind);
    }

    public void setDead(float health){
        if(this.health < 20)
            isDead = true;
    }
}
