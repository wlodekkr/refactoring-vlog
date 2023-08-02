package pl.refactoring.vlog03.todo;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import java.lang.Math;

public class Person {

    private final int id;
    private final String firstName;
    private final String lastName;

    private final CooperationType type;
    private final NightTimeRegulation nightTimeRegulation;

    private final int shiftHoursDuration;

    List<WorkRecord> registry = new ArrayList<>();

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

    public int getBaseSalary(){
        return switch (type) {
            case EMPLOYEE -> 10 * getAllHours();
            case INTERN -> 5 * getAllHours();
            case VOLUNTEER -> 0;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    public int getNighttimeSupplement() {
        int nightHours = getNightHours();

        if (nightHours < shiftHoursDuration / 4.0)
            return 0;

        return switch (type) {
            case EMPLOYEE, INTERN -> 2 * nightHours;
            case VOLUNTEER -> 0;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    public int getOvertimeSalary(){
        return 0;
    }

    public int getSickLeaveSalary(){
        return 0;
    }

    public int getBonusCoins(){
        return switch (type) {
            case EMPLOYEE -> (int) Math.round(0.25 * getBaseSalary());
            case INTERN -> 0;
            case VOLUNTEER -> 3 * getAllHours();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
