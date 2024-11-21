package event.lib;
import java.time.LocalDate;

public class CorporateEvent extends Event {
    private String venue;
    private boolean hasDiscount;

    public CorporateEvent(String eventTitle, String customerContact, LocalDate eventDate,
            int durationInDays, int numOfParticipants) {
        super(eventTitle, customerContact, eventDate, durationInDays, numOfParticipants);
        addPrefixCodeToId("CC");
    }
    public void setVenue(String venue){
        this.venue=venue;
    }
    @Override
    public double getBill() {
        if (hasDiscount == true) {
            return 0;
        }
        return 0;
    };
}