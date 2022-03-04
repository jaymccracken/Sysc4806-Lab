package Labs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Integer id;
    private String address, name, phonenumber;
    private int age;

    public BuddyInfo() {
    }

    /**
     * Instantiates a new buddy info.
     *
     * @param address the address
     * @param name the name
     * @param phonenumber the phonenumber
     * @param age the age
     */
    public BuddyInfo(String name, String address, String phonenumber, int age) {
        this.setAddress(address);
        this.setName(name);
        this.setPhonenumber(phonenumber);
        this.setAge(age);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }
    /**
     * @return address of this buddy
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return name of buddy
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return phonenumber of this buddy
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * sets phonenumber
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @return age of this buddy
     */
    public int getAge() {
        return age;
    }

    /**
     * sets age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the buddy object
     */
    public BuddyInfo getBuddy() {
        return this;
    }

//    /**
//     * prints out the buddy in a nice format
//     * @return
//     */
    public String write() {
        return name+"|"+age+"|"+phonenumber+"|"+address;
    }
}
