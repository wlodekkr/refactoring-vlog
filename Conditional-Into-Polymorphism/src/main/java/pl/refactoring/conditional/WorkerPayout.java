package pl.refactoring.conditional;

public class WorkerPayout {
    private Worker worker;

    enum Type {EMPLOYEE, CONTRACTOR, VOLUNTEER}

    public WorkerPayout(Worker worker) {
        this.worker = worker;
    }

    public int getPayoutAmount(int allHours){
        return getBaseSalary() + getOvertimeRate(allHours);
    }

    public int getBaseSalary(){
        if (worker.getType() == Type.EMPLOYEE)
            return worker.getBaseSalary();

        return 0;
    }

    public int getOvertimeRate(int allHours){
        if (worker.getType() == Type.EMPLOYEE && allHours > worker.getMonthlyHours()){
            return (int) (1.5 * worker.getBaseSalary() / (allHours - worker.getMonthlyHours()));
        }
        else if (worker.getType() == Type.CONTRACTOR) {
            return worker.getHourlyRate() * allHours;
        }

        return 0;
    }
}
