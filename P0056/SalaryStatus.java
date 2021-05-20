package P0056;

public class SalaryStatus {
    private Boolean isUp;
    private double amount;

    public SalaryStatus(double amount, Boolean isUp) {
        this.amount = amount;
        this.isUp = isUp;
    }

    public Boolean getIsUp() {
        return isUp;
    }

    public void setIsUp(Boolean isUp) {
        this.isUp = isUp;
    }

    public double getamount() {
        return amount;
    }

    public void setamount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return getIsUp() ? "UP" : "DOWN";
    }

}
