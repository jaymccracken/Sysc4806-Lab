package Labs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany( cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfo;

    /**
     * Instantiates a new address book.
     */
    public AddressBook () {
        this.buddyInfo = new ArrayList<BuddyInfo>();
    }

    /**
     * adds a buddy to the end of the list
     * @param aBuddyInfo
     */
    public void addBuddy(BuddyInfo aBuddyInfo) {
        if(aBuddyInfo != null) {
            buddyInfo.add(aBuddyInfo);
        }
    }

    /**
     * removes a buddy at a certain spot in the list
     * @param index
     */
    public void removeBuddy(int index) {
        if(index >=0 && index < buddyInfo.size()) {
            buddyInfo.remove(index);
        }
    }
    public BuddyInfo getBuddyInfo(int index){
        try {
            return buddyInfo.get(index);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Index");
            return null;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    /**
//     * printing the list out into new lines in order
//     * @return
//     */
//    public String toString() {
//        String output = "";
//        for (Labs.BuddyInfo infobuddy : buddyInfo) {
//            output += infobuddy.toString() + "\n";
//        }
//        return output;
//    }

    /**
     * gets the Size of the list.
     * @return the int
     */
    public int size() {
        return this.buddyInfo.size();
    }

    /**
     * clears the list
     */
    public void clear() {
        this.buddyInfo.clear();
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.launch();
    }

}

