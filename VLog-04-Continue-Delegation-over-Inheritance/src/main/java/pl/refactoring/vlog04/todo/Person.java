package pl.refactoring.vlog04.todo;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Person implements WorkRecordsSummary {

    private final int id;
    private final String firstName;
    private final String lastName;

    protected final CooperationType type;
    protected final NightTimeRegulation nightTimeRegulation;

    private final int shiftHoursDuration;

    protected List<WorkRecord> registry = new ArrayList<>();
    Accountancy accountancy;

    public Person(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration, Accountancy accountancy1) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.nightTimeRegulation = nightTimeRegulation;
        this.shiftHoursDuration = shiftHoursDuration;
        accountancy = accountancy1;
    }

    public void registerTime(Instant begin, Instant end){
        WorkRecord record = WorkRecord.registerWork(begin, end);

        registry.add(record);
    }

    @Override
    public int getAllHours(){
        return getAllMinutes() / 60;
    }

    public int getAllMinutes() {
        long minutes = registry.stream()
                .map(WorkRecord::getDuration)
                .mapToLong(Duration::toMinutes)
                .sum();

        return (int) minutes;
    }

    @Override
    public int getNightHours() {
        return getNightMinutes()/ 60;
    }

    public int getNightMinutes() {
        long minutes = registry.stream()
                .map(workRecord -> workRecord.getNighttimeDuration(nightTimeRegulation))
                .mapToLong(Duration::toMinutes)
                .sum();

        return (int) minutes;
    }

    public int getOvertimeMinutes(){
        return 0;
    }

    public int getBaseSalary(){
        return accountancy.getBaseSalary(this);
    }

    public int getNighttimeSupplement() {
        return accountancy.getNighttimeSupplement(this);
    }

    public int getOvertimeSalary(){
        return accountancy.getOvertimeSalary(this);
    }

    public int getSickLeaveSalary(){
        return accountancy.getSickLeaveSalary(this);
    }

    public int getBonusCoins(){
        return accountancy.getBonusCoins(this);
    }

    @Override
    public int getShiftHoursDuration() {
        return shiftHoursDuration;
    }
}
