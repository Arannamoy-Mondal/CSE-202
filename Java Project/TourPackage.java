import java.time.LocalDate;
import java.util.ArrayList;

public class TourPackage extends Event {
    ArrayList<String> placesToVisit = new ArrayList<>();
    ArrayList<String> customerContacts = new ArrayList<>();
    private int numOfRegisteredParticipants;
    
    public TourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants,
            int perPersonPrice) {
        super(eventTitle, eventDate, durationInDays, numOfParticipants, perPersonPrice);
    }
    public boolean registerForTour(int participants, String contactNo){
        numOfRegisteredParticipants;
    }
    public double getBill(){
        int totalBill=numOfRegisteredParticipants;
        return totalBill;
    }
}