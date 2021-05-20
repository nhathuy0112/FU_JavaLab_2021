package P0081;

public abstract class Bee {
    protected String kind;
    protected float health = 100;
    protected boolean isDead = false;

    public Bee(String kind){
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public float getHealth() {
        return health;
    }

    public void damage(float damage) {
        if (isDead == false)
            health = health - damage;
    }

    public boolean isDead() {
        return isDead;
    }

    public abstract void setDead(float health);


    public String toString() {
        if(isDead == true){
            return String.format("%s "+"| "+"%.2f "+"| "+"Dead", kind, (health <= 0 ? 0:health));
        }else{
            return String.format("%s "+"| "+"%.2f "+"| "+"Alive", kind, (health <= 0 ? 0:health));
        }
    }


    
}
