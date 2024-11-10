import java.util.*;
public class test {
    public static void main(String[] args) {
        CorporateEvent cc = new CorporateEvent("Reception", "0171721535", null, 25, 100);
        cc.addTask("Welcome", "Welcome Everyone");
        cc.addTask("Celebretion", "Celebretion");
        System.err.println(cc);
        System.out.println(cc.findTask("Welcome"));
        System.out.println(cc.findTask("hello"));
    }
}
