// package event.lib;

import java.time.*;
import java.time.format.*;

public class task {
    private String title, description, status;
    private LocalDate startDate, endDate;

    task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "New";
    }

    // getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    // setter method
    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void startTask() {
        status = "Progress";
        startDate = LocalDate.now();
    }

    public void completeTask() {
        status = "Completed";
        endDate = LocalDate.now();
    }

    public String toString() {
        return "{ Title: " + title + ",\nDescription: " + description + ",\nStatus: " + status + " }";
    }

}