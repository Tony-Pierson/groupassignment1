import java.time.LocalDate;
import java.time.Period;

public class InventoryItem {
    private String id, name, type;
    private LocalDate checkoutDate = null;
    private LocalDate dueDate = null;
    private boolean checkedOut = false;
    private int daysUntilDue = 0;

    //constructors
    InventoryItem(){
        id = "";
        name = "";
        type = "";
    }
    InventoryItem(String idNumber, String itemName, String itemType){
        id = idNumber;
        name = itemName;
        type = itemType;
    }
    InventoryItem(String idNumber, String itemName, String itemType, boolean isCheckedOut, String due, String checkOutDt){
        id = idNumber;
        name = itemName;
        type = itemType;
        checkedOut = isCheckedOut;
        LocalDate dDate = LocalDate.parse(due);
        dueDate = dDate;
        LocalDate cDate = LocalDate.parse(checkOutDt);
        checkoutDate = cDate;
    }
    InventoryItem(InventoryItem i){
        if(i == null){
            System.out.println("Fatal error");
            System.exit(0);
        }
        id = i.id;
        name = i.name;
        type = i.type;
    }

    //checkin/out methods
    public void checkOut(){
        checkedOut = true;
        checkoutDate = LocalDate.now();
        dueDate = checkoutDate.plusDays(14);
    }
    public void checkIn(){
        checkedOut = false;
        checkoutDate = null;
        dueDate = null;
    }
    public boolean isCheckedOut(){
        return checkedOut;
    };

    //getters
    public String getCheckoutDate(){
        //System.out.println(dueDate);
        if(checkoutDate == null){
            return null;
        }
        else{
            return  checkoutDate.toString();
        }
    }
    public String getDueDate(){
        //System.out.println(dueDate);
        if(dueDate == null){
            return null;
        }
        else{
            return  dueDate.toString();
        }
    }
    public int getDaysUntilDue(){
        if(dueDate != null) {
            daysUntilDue = Period.between(LocalDate.now(), dueDate).getDays();
            return daysUntilDue;
        }
        else return 0;
    }
    public String getID(){
        return id;
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
}
