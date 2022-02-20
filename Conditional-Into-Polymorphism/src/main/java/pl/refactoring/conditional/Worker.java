package pl.refactoring.conditional;

import java.util.Optional;

public class Worker {
    private String firstName;
    private String lastName;

    private WorkerPayout.Type type;

    // Used by employees
    private Optional<Integer> baseSalary;
    private Optional<Integer> monthlyHours;

    // Used by contractors
    private Optional<Integer> hourlyRate;

    // Student - working for free
    public Worker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = WorkerPayout.Type.VOLUNTEER;
    }

    // Employee - full-time or part-time
    public Worker(String firstName, String lastName, Integer baseSalary, Integer monthlyHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = WorkerPayout.Type.EMPLOYEE;

        this.baseSalary = Optional.of(baseSalary);
        this.monthlyHours = Optional.of(monthlyHours);
    }

    // Contractor - paid by each hour
    public Worker(String firstName, String lastName, Integer hourlyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = WorkerPayout.Type.CONTRACTOR;

        this.hourlyRate = Optional.of(hourlyRate);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public WorkerPayout.Type getType() {
        return type;
    }

    public Integer getBaseSalary() {
        return baseSalary.get();
    }

    public Integer getMonthlyHours() {
        return monthlyHours.get();
    }

    public Integer getHourlyRate() {
        return hourlyRate.get();
    }
}
