// package event.lib;
import java.time.LocalDate;
import java.util.ArrayList;

public class TourPackage extends Event {
    ArrayList<String> placesToVisit;
    ArrayList<String> customerContacts;
    private int numOfRegisteredParticipants,perPersonPrice;
    public TourPackage(String eventTitle, String customerContact,LocalDate eventDate, int durationInDays, int numOfParticipants,
            int perPersonPrice) {
        super(eventTitle, customerContact, eventDate, durationInDays, numOfParticipants);
        this.placesToVisit = new ArrayList<>();
        this.customerContacts = new ArrayList<>();
        this.perPersonPrice=perPersonPrice;
        addPrefixCodeToId("TP");
    }
    
    // getter methods

    public int geTperPersonPrice(){return perPersonPrice;}


    public boolean registerForTour(int participants, String contactNo){
        if(geTnumOfParticipants()<=(numOfRegisteredParticipants+participants)){
            numOfRegisteredParticipants+=participants;
            customerContacts.add(contactNo);
            return true;
        }
        return false;
    }


    public void addPlacesToVisit(String placeToVisit){
        placesToVisit.add(placeToVisit);
    }


    public double getBill() {
        int totalBill = numOfRegisteredParticipants*perPersonPrice;
        return totalBill;
    }
}