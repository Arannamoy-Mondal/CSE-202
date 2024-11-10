import java.time.LocalDate;
import java.util.ArrayList;

public class EventPlanner {
    private String name;
    private ArrayList<Event> events, requestedEvents;

    public EventPlanner(String name) {
        this.name = name;
        this.events = new ArrayList<>();
        this.requestedEvents = new ArrayList<>();
    }

    public Event findEvent(String id) {
        for (Event it : events) {
            if (it.geTeventId().equals(id)) {
                return it;
            }
        }
        return null;
    }

    public Event findRequestedEvent(String id) {
        for (Event it : requestedEvents) {
            if (it.geTeventId().equals(id)) {
                return it;
            }
        }
        return null;
    }

    public ArrayList<Event> searchEvents(String title) {
        ArrayList<Event> ans = new ArrayList<>();
        for (Event it : events) {
            if (it.geTeventTitle().equals(ans)) {
                ans.add(it);
            }
        }
        return ans;
    }

    public ArrayList<TourPackage> searchForTourPackages(String title) {
        ArrayList<TourPackage> ans = new ArrayList<>();
        for (Event it : events) {
            String chk = it.geTeventId();
            if (chk.charAt(0) == 'T' && chk.charAt(1) == 'P' && it.geTeventTitle().equals(title)) {
                ans.add(new TourPackage(it.geTeventTitle(), it.geTeventDate(), it.geTdurationInDays(),
                        it.geTnumOfParticipants(), it.geTunitPrice()));
            }
        }
        return ans;
    }

    public String requestEvent(String eventTitle, String customerContact, LocalDate eventDate, int durationInDays,
            int numOfParticipants) {
        CorporateEvent chk = new CorporateEvent(eventTitle, customerContact, eventDate, durationInDays,
                numOfParticipants);
        requestedEvents.add(chk);
        return chk.geTeventId();
    }

    public void acceptEvent(String eventID) {
        Event chk = findRequestedEvent(eventID);
        if (chk != null) {
            requestedEvents.remove(chk);
        }
    }

    public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants,
            int perPersonPrice,
            ArrayList<String> placesToVisit) {
        TourPackage chk = new TourPackage(eventTitle, eventDate, durationInDays, numOfParticipants, perPersonPrice);
        events.add(chk);
        return chk.geTeventId();
    }

    public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants,
            int perPersonPrice) {
        TourPackage chk = new TourPackage(eventTitle, eventDate, durationInDays, numOfParticipants, perPersonPrice);
        events.add(chk);
        return chk.geTeventId();
    }

    public void registerForTour(String tourId, int participants, String contact) {
        Event chk = findEvent(tourId);
        // System.out.println(chk);
        // if (chk!=null) {
        //     thk.registerForTour(participants, contact);
        // }
    }

}
