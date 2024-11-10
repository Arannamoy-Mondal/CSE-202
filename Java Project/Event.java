// package event.lib;

import java.time.*;
import java.util.ArrayList;
import java.util.Random;
import java.time.format.*;

abstract public class Event {
    private String eventTitle, eventId, eventManager, customerContact;
    private LocalDate eventDate;
    private int durationInDays, numOfParticipants, unitPrice;
    private ArrayList<task> tasks;

    public Event(String eventTitle, String customerContact, LocalDate eventDate, int durationInDays,
            int numOfParticipants) {
        this.eventTitle = eventTitle;
        this.customerContact = customerContact;
        this.eventDate = eventDate;
        this.durationInDays = durationInDays;
        this.numOfParticipants = numOfParticipants;
        this.eventId = String.format("%d", new Random().nextInt(1000));
        this.eventManager = null;
        this.tasks = new ArrayList<>();
    };

    // getter methods

    public String geTeventTitle() {
        return eventTitle;
    }

    public String geTeventId() {
        return eventId;
    }

    public String geTeventManager() {
        return eventManager;
    }

    public String geTcustomerContact() {
        return customerContact;
    }

    public int geTdurationInDays() {
        return durationInDays;
    }

    public int geTnumOfParticipants() {
        return numOfParticipants;
    }

    public int geTunitPrice() {
        return unitPrice;
    }

    public LocalDate geTeventDate() {
        return eventDate;
    }

    // setter methods
    protected void addPrefixCodeToId(String prefix) {
        eventId = prefix + eventId;
    };

    public void setEventManager(String name) {
        eventManager = name;
    }

    public void addTask(String title, String description) {
        tasks.add(new task(title, description));
    };

    public task findTask(String title) {
        for (task it : tasks) {
            if (it.getTitle().equals(title)) {
                return it;
            }
        }
        return null;
    };

    public boolean startTask(String title) {
        task tmp = findTask(title);
        if (findTask(title) != null) {
            tmp.startTask();
            return true;
        }
        return false;
    }

    public boolean completeTask(String title) {
        task tmp = findTask(title);
        if (findTask(title) != null) {
            tmp.completeTask();
            return true;
        }
        return false;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = LocalDate.parse(eventDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String toString() {
        return "Event title: " + eventTitle + "\nEvent id: " + eventId +
                "\nEvent manager: " + eventManager +
                "\nCsutomer contact: " + customerContact + "\nEvent date: " + eventDate + "\nDuration in days: "
                + durationInDays + "\nNum of participants: " + numOfParticipants + "\nUnit price: " + unitPrice
                + "\nTasks " + tasks;
    }

    public abstract double getBill();
}
