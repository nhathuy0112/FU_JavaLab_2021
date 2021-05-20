package P0056;

import java.time.LocalDate;

public class SalaryHistory {
    private LocalDate date;
    private Worker worker;
    private SalaryStatus status;

    public SalaryHistory(Worker worker, SalaryStatus status) {
        date = LocalDate.now();
        this.worker = worker;
        this.status = status;
    }

    public String toString() {
        return String.format("%8s %10s %12d %14.2f %16s %18s", worker.getId(),worker.getName(),worker.getAge(),worker.getSalary(),status.toString(),date);
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

}
