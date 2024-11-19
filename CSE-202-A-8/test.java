import java.time.LocalDate;
public class test {
    public static void main(String[] args) {
        TourPackage tp=new TourPackage("Tp01","017123456789",LocalDate.now(),25,100,1000);
        System.out.println(tp.geTperPersonPrice());
        tp.registerForTour(10,"012345678912");
        System.out.println(tp.getBill());
        System.out.println(tp.geTnumOfParticipants());
        System.out.println(tp.getNumOfRegisteredParticipates());
    }
}
