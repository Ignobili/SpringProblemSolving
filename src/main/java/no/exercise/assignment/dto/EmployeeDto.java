package no.exercise.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;
public record EmployeeDto(
        String name,
        int age,
        String departmentName,
        Instant startDate,
        Instant endDate
) {
    @JsonIgnore
    public boolean isActive() {
        return endDate == null;
    }
}
