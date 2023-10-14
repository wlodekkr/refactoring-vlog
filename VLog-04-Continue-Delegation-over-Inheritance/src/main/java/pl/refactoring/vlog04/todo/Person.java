package pl.refactoring.vlog04.todo;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    private final int id;
    private final String firstName;
    private final String lastName;

    protected final CooperationType type;
    protected final NightTimeRegulation nightTimeRegulation;

    protected final int shiftHoursDuration;

    protected List<WorkRecord> registry = new ArrayList<>();

    public Person(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.nightTimeRegulation = nightTimeRegulation;
        this.shiftHoursDuration = shiftHoursDuration;
    }

    public void registerTime(Instant begin, Instant end){
        WorkRecord record = WorkRecord.registerWork(begin, end);

        registry.add(record);
    }

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

    public abstract int getBaseSalary();

    public abstract int getNighttimeSupplement();

    public abstract int getOvertimeSalary();

    public abstract int getSickLeaveSalary();

    public abstract int getBonusCoins();
}
